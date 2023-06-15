package com.example.designprojects92060869;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DetailedProfile extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_profile);

        // Set up click listener for btnEdit
        button = (Button) findViewById(R.id.btnEdit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to navigate to Profile activity
                Intent intent = new Intent(DetailedProfile.this, Profile.class);
                startActivity(intent);
            }
        });
    }
}
