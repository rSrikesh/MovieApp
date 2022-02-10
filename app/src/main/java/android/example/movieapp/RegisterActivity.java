package android.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private TextInputLayout registerEmail,registerPassword;
    private Button registerBtn;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        registerBtn = findViewById(R.id.registerBtn);
        mAuth = FirebaseAuth.getInstance();

        registerBtn.setOnClickListener(v -> registerUser());
    }

    private void registerUser(){
        String email = registerEmail.getEditText().getText().toString().trim();
        String password = registerPassword.getEditText().getText().toString().trim();
        if (email.equals("") || password.equals("")){
            Toast.makeText(RegisterActivity.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
        }else{
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(RegisterActivity.this, task -> {
                        if(task.isSuccessful()){
                            Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                        }else{
                            Toast.makeText(RegisterActivity.this, "Registration Unsuccessful "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}