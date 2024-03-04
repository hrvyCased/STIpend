package com.example.stipend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class PaymentActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        EditText amount = findViewById(R.id.amountNumber);
        Button payBtn = findViewById(R.id.proceedBtn);
        payBtn.setOnClickListener(v -> {
            double amountValue = Double.parseDouble(amount.getText().toString());
            if (Loan.getInstance().payBalanceAvailability(amountValue)) {
                Loan.getInstance().payBalance(amountValue);
                amount.setText("");
                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                builder.setTitle("Success").setMessage("Payment successful.")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss()).show();
            } else if (String.valueOf(amountValue).isEmpty() || amountValue <= 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                builder.setTitle("Error").setMessage("Please enter a valid amount.")
                        .setPositiveButton("OK", (dialog, which) -> dialog.dismiss()).show();
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                builder.setTitle("Error").setMessage(String.format("You do not have this amount to pay. Please enter a valid amount.\nRemaining balance: %.2f", Loan.getInstance().showBalance()))
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss()).show();
            }
        });
    }
}
