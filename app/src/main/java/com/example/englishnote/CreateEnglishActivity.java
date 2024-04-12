package com.example.englishnote;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import com.example.englishnote.database.AppDatabase;
import com.example.englishnote.model.Vocabulary;
import com.example.englishnote.model.VocabularyType;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class CreateEnglishActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_english);

        LinearLayout parentView = findViewById(R.id.activity_create_english);
        MaterialToolbar toolbar = parentView.findViewById(R.id.toolbar_2);
        setSupportActionBar(toolbar);

        Button btnBack = findViewById(R.id.btn_back_vo);
        btnBack.setOnClickListener(view -> {
            Intent switch1 = new Intent(this, MainActivity.class);
            startActivity(switch1);
            finish();
        });

        Spinner spinner = findViewById(R.id.spin_vo_type);

        AppDatabase appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "vocabulary-database").allowMainThreadQueries().build();

        List<VocabularyType> vocabularyTypes = appDatabase.vocabularyTypeDao().findAll();
        ArrayAdapter<VocabularyType> spinnerAdapter = new ArrayAdapter<>(getApplicationContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item, vocabularyTypes);
        spinnerAdapter.setDropDownViewResource(androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(spinnerAdapter);

        appDatabase.close();

        Button createVo = findViewById(R.id.btn_add_new_vo);
        createVo.setOnClickListener(view -> {
            final EditText edtVolName = findViewById(R.id.edt_vo_name);
            String name = edtVolName.getText().toString();

            final EditText edtVolDesc = findViewById(R.id.edt_vo_desc);
            String desc = edtVolDesc.getText().toString();

             VocabularyType vocabularyType = (VocabularyType) spinner.getSelectedItem();

            Vocabulary vocabulary = new Vocabulary();
            vocabulary.setName(name);
            vocabulary.setDesc(desc);
            vocabulary.setTypeId(vocabularyType.getId());

            AppDatabase appDatabase2 = Room.databaseBuilder(getApplicationContext(),
                    AppDatabase.class, "vocabulary-database").allowMainThreadQueries().build();

            appDatabase2.vocabularyDao().insert(vocabulary);

            Toast.makeText(getApplicationContext(), "Add Successfully", Toast.LENGTH_LONG).show();
            edtVolName.setText(null);
            edtVolDesc.setText(null);
            appDatabase2.close();
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