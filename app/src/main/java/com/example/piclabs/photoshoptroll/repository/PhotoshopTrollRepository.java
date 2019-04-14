package com.example.piclabs.photoshoptroll.repository;

import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.piclabs.photoshoptroll.database.UrlDao;
import com.example.piclabs.photoshoptroll.entity.UrlEntity;

import java.util.List;

import javax.inject.Singleton;

@Singleton
public class PhotoshopTrollRepository {
    private final UrlDao urlDao;

    public PhotoshopTrollRepository(UrlDao urlDao) {
        this.urlDao = urlDao;
    }

    @NonNull
    public LiveData<List<UrlEntity>> getUrls() {
        return urlDao.getAll();
    }
}
