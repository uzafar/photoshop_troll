package com.example.piclabs.photoshoptroll.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.piclabs.photoshoptroll.database.UrlDatabase;
import com.example.piclabs.photoshoptroll.database.UrlDatabaseAsyncTask;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class PhotoshopTrollSplashScreenActivity extends AppCompatActivity {
    @Inject
    UrlDatabase urlDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        // load url assets
        new UrlDatabaseAsyncTask(this).execute(urlDatabase.urlDao());
    }

    public void startMainActivity() {
        Intent intent = new Intent(getApplicationContext(), PhotoshopTrollActivity.class);
        startActivity(intent);
        finish();
    }
}
