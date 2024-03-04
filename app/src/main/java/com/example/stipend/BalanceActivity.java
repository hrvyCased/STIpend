package com.example.stipend;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class BalanceActivity extends AppCompatActivity {
    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        Loan.getInstance();
        TextView dateTime = findViewById(R.id.date);
        TextView amountText = findViewById(R.id.amountText);
        dateTime.setText(String.format("DATE: %s\tTIME: %s", getDate(), getTime()));
        amountText.setText(String.format("₱%.2f", Loan.getInstance().showBalance()));
    }

    public String getDate() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate date = LocalDate.now(ZoneId.of("Asia/Manila"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
            return date.format(formatter);
        }
        return "Not available";
    }

    public String getTime() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalTime time = LocalTime.now(ZoneId.of("Asia/Manila"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm a");
            return time.format(formatter);
        }
        return "Not available";
    }
}
