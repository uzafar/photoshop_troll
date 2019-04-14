package com.example.piclabs.photoshoptroll.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.piclabs.photoshoptroll.entity.UrlEntity;

import java.util.List;

@Dao
public interface UrlDao {
    @Query("SELECT * FROM UrlEntity")
    LiveData<List<UrlEntity>> getAll();

    @Insert
    void insertAll(UrlEntity... urlEntities);

    @Query("DELETE FROM UrlEntity")
    void deleteAll();
}
