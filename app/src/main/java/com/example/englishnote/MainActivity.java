package com.example.englishnote;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("UseSupportActionBar")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        LinearLayout parentView = findViewById(R.id.main);
        MaterialToolbar toolbar = parentView.findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        Button btnCreate = toolbar.findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(view -> {
            Intent switch1 = new Intent(this, CreateEnglishActivity.class);
            startActivity(switch1);
        });

        Button btnCreateType = toolbar.findViewById(R.id.btnCreateType);
        btnCreateType.setOnClickListener(view -> {
            Intent switch1 = new Intent(this, CreateEnglishTypeActivity.class);
            startActivity(switch1);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }
}