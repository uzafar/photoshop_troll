package com.example.piclabs.photoshoptroll.modules;


import android.app.Application;
import android.support.annotation.NonNull;

import com.example.piclabs.photoshoptroll.database.UrlDao;
import com.example.piclabs.photoshoptroll.database.UrlDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    @Singleton
    @Provides
    UrlDatabase provideUrlDatabase(@NonNull Application mApplication) {
        return UrlDatabase.getDatabase(mApplication);
    }

    @Singleton
    @Provides
    UrlDao providesUrlDao(@NonNull UrlDatabase urlDatabase) {
        return urlDatabase.urlDao();
    }
}