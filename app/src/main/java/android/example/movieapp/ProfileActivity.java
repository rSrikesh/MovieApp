package android.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import io.ak1.BubbleTabBar;
import io.ak1.OnBubbleClickListener;

public class ProfileActivity extends AppCompatActivity {
    private TextView profileEmail;
    FirebaseUser mUser;
    FirebaseAuth mAuth;
    private Button signOut;
    BubbleTabBar btmProfile;
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

        btmProfile.addBubbleListener(new OnBubbleClickListener() {
            @Override
            public void onBubbleClick(int i) {
                if(i == R.id.navbar_home){
                    startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                }else if(i == R.id.navbar_fav){
                    startActivity(new Intent(ProfileActivity.this,FavouriteMovie.class));
                }
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

