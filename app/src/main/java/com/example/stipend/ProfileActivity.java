package com.example.stipend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class ProfileActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Button devBtn = findViewById(R.id.devBtn);
        Button logoutBtn = findViewById(R.id.logoutBtn);
        devBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, DeveloperActivity.class);
            startActivity(intent);
        });
        logoutBtn.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
            builder.setTitle("Logout")
            .setMessage("Are you sure you want to logout?")
            .setPositiveButton("Yes", (dialog, which) -> finishAffinity())
            .setNegativeButton("No", (dialog, which) -> dialog.dismiss()).show();
        });
    }
}
