package com.example.designprojects92060869;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Payment extends AppCompatActivity {
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Set up click listener for paybtn
        button = (Button) findViewById(R.id.paybtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create intent to navigate to PaymentBox activity
                Intent intent = new Intent(Payment.this, PaymentBox.class);
                startActivity(intent);
            }
        });
    }
}

