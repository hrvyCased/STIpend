package com.example.stipend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;

public class GetLoanActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_loan);
        Loan.getInstance();
        Button getLoanBtn = findViewById(R.id.loanBtn);
        getLoanBtn.setOnClickListener(v -> {
            if (Loan.getInstance().getLoanAvailability()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(GetLoanActivity.this);
                builder.setTitle("Loan Status").setMessage("Loan has been granted")
                        .setPositiveButton("Close", (dialog, which) -> dialog.dismiss()).show();
                Loan.getInstance().setLoan(Loan.getInstance().getLoanAvailability());
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(GetLoanActivity.this);
                builder.setTitle("Loan Status").setMessage("Loan not available, you still have an outstanding balance")
                        .setPositiveButton("Close", (dialog, which) -> dialog.dismiss()).show();
                Loan.getInstance().setLoan(Loan.getInstance().getLoanAvailability());
            }
        });
    }
}
