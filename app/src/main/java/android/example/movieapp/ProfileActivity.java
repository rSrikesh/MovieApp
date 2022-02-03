package android.example.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private TextView profileEmail;
    FirebaseUser mUser;
    FirebaseAuth mAuth;
    BottomNavigationView btmProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        profileEmail = findViewById(R.id.profileEmail);
        mUser = FirebaseAuth.getInstance().getCurrentUser();
        mAuth = FirebaseAuth.getInstance();
        profileEmail.setText(mUser.getEmail());
        btmProfile = findViewById(R.id.bottom2);
        btmProfile.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.navbar_home){
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    return true;
                }else if(item.getItemId() == R.id.navbar_fav){
                    startActivity(new Intent(getApplicationContext(),FavouriteMovie.class));
                    return true;
                }
                return false;
            }
        });
        getSupportActionBar().setTitle("User Profile");
    }
}