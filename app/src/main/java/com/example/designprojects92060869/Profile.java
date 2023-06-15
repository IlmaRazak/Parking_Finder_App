package com.example.designprojects92060869;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Profile extends AppCompatActivity {
    DBHelper DB;
    EditText Name, Email, Address, PhoneNumber;
    Button btnUpdateData, btnDelete, button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        DB = new DBHelper(this);

        // Initialize EditText fields and buttons
        Name = findViewById(R.id.editName);
        Address = findViewById(R.id.editAddress);
        PhoneNumber = findViewById(R.id.editPhone);
        btnUpdateData = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btndlt);

        updateProfile();
        deleteProfile();
    }

    // Method to update profile data
    public void updateProfile() {
        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the updateProfile method from DBHelper to update the profile
                boolean isUpdate = DB.updateProfile(
                        Name.getText().toString(),
                        Address.getText().toString(),
                        PhoneNumber.getText().toString());

                if (isUpdate) {
                    Toast.makeText(Profile.this, "Profile Updated", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Profile.this, "Please enter all the fields", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    // Method to delete profile
    public void deleteProfile() {
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the deleteProfile method from DBHelper to delete the profile
                Integer deleteRows = DB.deleteProfile(
                        Name.getText().toString(),
                        Address.getText().toString(),
                        PhoneNumber.getText().toString());

                if (deleteRows > 0) {
                    Toast.makeText(Profile.this, "Profile Deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Profile.this, "Profile not deleted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
