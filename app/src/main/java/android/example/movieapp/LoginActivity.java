package android.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    private TextInputLayout loginEmail , loginPassword;
    private Button loginBtn;
    private TextView toRegister;
    private FirebaseAuth mAuth;
    private SharedPreferences s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginEmail = findViewById(R.id.loginEmail);
        loginPassword = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        toRegister = findViewById(R.id.toRegsiter);
        mAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(v -> userLogin());

        toRegister.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));
    }

    private void userLogin(){
        String email = loginEmail.getEditText().getText().toString().trim();
        String password = loginPassword.getEditText().getText().toString().trim();
        if(email.equals("") || password.equals("")){
            Toast.makeText(LoginActivity.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
        }else{
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(LoginActivity.this, task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Logged In Successfully!!!", Toast.LENGTH_SHORT).show();
                            SharedPreferences sp = getSharedPreferences("loginStatus", MODE_PRIVATE);
                            SharedPreferences.Editor e = sp.edit();
                            e.putString("user", email);
                            e.putBoolean("Logged In", true);
                            e.apply();
                            startActivity(new Intent(LoginActivity.this, SplashActivity.class));
                        }else{
                            Toast.makeText(LoginActivity.this, "Log In Error "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
