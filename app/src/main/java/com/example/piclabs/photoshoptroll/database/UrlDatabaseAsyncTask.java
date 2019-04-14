package com.example.piclabs.photoshoptroll.database;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.piclabs.photoshoptroll.activities.PhotoshopTrollSplashScreenActivity;
import com.example.piclabs.photoshoptroll.assets.UrlAssets;

public class UrlDatabaseAsyncTask extends AsyncTask<UrlDao, Void, Void> {
    private PhotoshopTrollSplashScreenActivity photoshopTrollSplashScreenActivity;
    private UrlDao[] urlDaos;

    public UrlDatabaseAsyncTask(@NonNull PhotoshopTrollSplashScreenActivity photoshopTrollSplashScreenActivity) {
        this.photoshopTrollSplashScreenActivity = photoshopTrollSplashScreenActivity;
    }

    @Override
    protected Void doInBackground(UrlDao... urlDaos) {
        if (urlDaos == null || urlDaos.length == 0) {
            return null;
        }
        this.urlDaos = urlDaos;
        for (int i=0; i < urlDaos.length; i++) {
            urlDaos[i].deleteAll();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        if (urlDaos == null || urlDaos.length == 0) {
            return;
        }
        new UrlDatabaseInsertTask().execute(urlDaos);
    }

    private class UrlDatabaseInsertTask extends AsyncTask<UrlDao, Void, Void> {
        @Override
        protected Void doInBackground(UrlDao... urlDaos) {
            for (int i=0; i < urlDaos.length; i++) {
                urlDaos[i].insertAll(UrlAssets.getUrlEntities());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            photoshopTrollSplashScreenActivity.startMainActivity();
        }
    }
}
