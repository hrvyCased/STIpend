package com.example.stipend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loan.getInstance();
        ImageView profileImg = findViewById(R.id.profileImg);
        Button balanceBtn = findViewById(R.id.balanceBtn);
        Button payBalanceBtn = findViewById(R.id.payBalanceBtn);
        Button getLoanBtn = findViewById(R.id.getLoanBtn);
        Button otherBtn = findViewById(R.id.otherBtn);
        profileImg.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
        balanceBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, BalanceActivity.class);
            startActivity(intent);
        });
        payBalanceBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, PaymentActivity.class);
            startActivity(intent);
        });
        getLoanBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GetLoanActivity.class);
            startActivity(intent);
        });
        otherBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, OtherActivity.class);
            startActivity(intent);
        });
    }
}
