package com.example.helmut.heroapp.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.helmut.heroapp.model.HeroModel;

import java.util.List;

@Dao
public interface HeroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(HeroModel heroModel);

    @Delete
    void Delete();

    @Query("SELECT * FROM Hero")
    LiveData<List<HeroModel>> GetAll();




}
