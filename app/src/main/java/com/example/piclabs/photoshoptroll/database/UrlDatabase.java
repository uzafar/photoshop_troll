package com.example.piclabs.photoshoptroll.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.piclabs.photoshoptroll.entity.UrlEntity;

@Database(entities = {UrlEntity.class}, version = 1, exportSchema = false)
public abstract class UrlDatabase extends RoomDatabase {
    public abstract UrlDao urlDao();
    private static UrlDatabase INSTANCE;

    public static UrlDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UrlDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UrlDatabase.class,
                            "photoshoptroll-url-database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}