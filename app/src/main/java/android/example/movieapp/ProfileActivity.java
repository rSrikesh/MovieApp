package android.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private TextView profileEmail;
    FirebaseUser mUser;
    FirebaseAuth mAuth;
    private Button signOut;
    BottomNavigationView btmProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileEmail = findViewById(R.id.profileEmail);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        profileEmail.setText(mUser.getEmail());
        btmProfile = findViewById(R.id.bottom2);
        signOut = findViewById(R.id.signout);
        btmProfile.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.navbar_home){
                    startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                    return true;
                }else if(item.getItemId() == R.id.navbar_fav){
                    startActivity(new Intent(ProfileActivity.this,FavouriteMovie.class));
                    return true;
                }
                return false;
            }
        });
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
            }
        });

        getSupportActionBar().setTitle("User Profile");
    }
}

