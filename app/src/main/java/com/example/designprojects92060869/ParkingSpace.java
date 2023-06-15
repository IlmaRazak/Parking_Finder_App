package com.example.designprojects92060869;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class ParkingSpace extends AppCompatActivity {
    public ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_space);

        // Set up click listener for imageButton1
        button = (ImageButton) findViewById(R.id.imageButton1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to navigate to SlotDetail activity
                Intent intent = new Intent(ParkingSpace.this, SlotDetail.class);
                startActivity(intent);
            }
        });

        // Set up click listener for btnProfile
        button = (ImageButton) findViewById(R.id.btnProfile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to navigate to DetailedProfile activity
                Intent intent = new Intent(ParkingSpace.this, DetailedProfile.class);
                startActivity(intent);
            }
        });
    }
}
