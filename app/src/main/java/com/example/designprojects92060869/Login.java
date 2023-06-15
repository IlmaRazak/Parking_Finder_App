package com.example.designprojects92060869;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    // Declare variables
    TextView loginRedirectText;
    Button loginButton;
    EditText loginUsername, loginPassword;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize variables
        loginRedirectText = findViewById(R.id.loginRedirectText);
        loginButton = findViewById(R.id.login_button);
        loginUsername = findViewById(R.id.login_username);
        loginPassword = findViewById(R.id.login_password);
        DB = new DBHelper(this);

        // Set up click listener for loginRedirectText
        loginRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(Login.this, SignUp.class);
            startActivity(intent);
        });

        // Set up click listener for loginButton
        loginButton.setOnClickListener(view -> {
            String username = loginUsername.getText().toString();
            String password = loginPassword.getText().toString();

            if (username.equals("") || password.equals("")) {
                Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            } else {
                Boolean checkEmailPassword = DB.checkUserExists(username, password);
                if (checkEmailPassword) {
                    Toast.makeText(Login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ParkingSpace.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
