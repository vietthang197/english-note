package com.example.englishnote.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.englishnote.dao.VocabularyTypeDao;
import com.example.englishnote.model.Vocabulary;
import com.example.englishnote.model.VocabularyType;

@Database(entities = {Vocabulary.class, VocabularyType.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VocabularyTypeDao vocabularyTypeDao();
}
