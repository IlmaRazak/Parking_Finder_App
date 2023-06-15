package com.example.designprojects92060869;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SlotDetail extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slot_detail);

        button = (Button) findViewById(R.id.btnPay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SlotDetail.this,Payment.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.btnMap);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SlotDetail.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        button = (Button) findViewById(R.id.btnReview);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SlotDetail.this,Review.class);
                startActivity(intent);
            }
        });
    }
}


