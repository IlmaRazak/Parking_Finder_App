package com.example.designprojects92060869;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    //Declare Variable
    Button signupButton;
    EditText signupName, signupUsername, signupPassword, signupRePassword;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signupButton = findViewById(R.id.signup_button);
        DB = new DBHelper(this);

        signupName = findViewById(R.id.signup_name);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        signupRePassword = findViewById(R.id.signup_repassword);

        signupButton.setOnClickListener(view -> {
            String name = signupName.getText().toString();
            String username = signupUsername.getText().toString();
            String password = signupPassword.getText().toString();
            String repassword = signupRePassword.getText().toString();

            if (name.equals("") || username.equals("") || password.equals("") || repassword.equals("")) {
                Toast.makeText(SignUp.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else if (!password.equals(repassword)) {
                Toast.makeText(SignUp.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
            }else if (DB.checkUsernameExists(username)) {
                    Toast.makeText(SignUp.this, "Username already exists", Toast.LENGTH_SHORT).show();
                } else if (DB.checkNameAndUsernameExists(name, username)) {
                    Toast.makeText(SignUp.this, "Name and username already exists", Toast.LENGTH_SHORT).show();
                } else {
                    boolean success = DB.insertData(name, username, password, repassword);
                    if (success) {
                        Toast.makeText(SignUp.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUp.this, ParkingSpace.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(SignUp.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}
