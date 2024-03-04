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
            openIntent(ProfileActivity.class);
        });
        balanceBtn.setOnClickListener(v -> {
            openIntent(BalanceActivity.class);
        });
        payBalanceBtn.setOnClickListener(v -> {
            openIntent(PaymentActivity.class);
        });
        getLoanBtn.setOnClickListener(v -> {
            openIntent(GetLoanActivity.class);
        });
        otherBtn.setOnClickListener(v -> {
            openIntent(OtherActivity.class);
        });
    }
    protected void openIntent(Class<?> cls) {
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
    }
}
