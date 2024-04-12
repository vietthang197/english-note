package com.example.englishnote.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.englishnote.model.VocabularyType;

import java.util.List;

@Dao
public interface VocabularyTypeDao {

    @Insert
    void insert(VocabularyType vocabularyType);

    @Query("SELECT * FROM vocabularytype")
    List<VocabularyType> findAll();
}
