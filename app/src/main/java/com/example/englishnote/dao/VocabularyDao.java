package com.example.englishnote.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.englishnote.model.Vocabulary;
import com.example.englishnote.model.VocabularyType;

import java.util.List;

@Dao
public interface VocabularyDao {

    @Insert
    void insert(Vocabulary vocabulary);

    @Query("SELECT * FROM vocabulary")
    List<Vocabulary> findAll();
}
