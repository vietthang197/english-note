package com.example.englishnote;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.englishnote.database.AppDatabase;
import com.example.englishnote.model.VocabularyType;
import com.google.android.material.appbar.MaterialToolbar;

public class CreateEnglishTypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_english_type);

        LinearLayout parentView = findViewById(R.id.activity_create_english_type);
        MaterialToolbar toolbar = parentView.findViewById(R.id.toolbar_2);
        setSupportActionBar(toolbar);

        Button btnBack = findViewById(R.id.btn_back_vo_type);
        btnBack.setOnClickListener(view -> {
            Intent switch1 = new Intent(this, MainActivity.class);
            startActivity(switch1);
            finish();
        });

        Button btnCreateType = findViewById(R.id.btn_add_new_vo_type);

        btnCreateType.setOnClickListener(view -> {

            final EditText edtVolType = findViewById(R.id.edt_vo_type);
            String name = edtVolType.getText().toString();

            final EditText edtVolTypeDesc = findViewById(R.id.edt_vo_type_description);
            String desc = edtVolTypeDesc.getText().toString();
            final VocabularyType vocabularyType = new VocabularyType();
            vocabularyType.setName(name);
            vocabularyType.setDesc(desc);

            AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "vocabulary-database").allowMainThreadQueries().build();
            appDatabase.vocabularyTypeDao().insert(vocabularyType);
            Toast.makeText(getApplicationContext(), "Add Successfully", Toast.LENGTH_LONG).show();
            edtVolType.setText(null);
            edtVolTypeDesc.setText(null);
            appDatabase.close();


        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent switch1 = new Intent(this, MainActivity.class);
        startActivity(switch1);
        finish();
    }
}