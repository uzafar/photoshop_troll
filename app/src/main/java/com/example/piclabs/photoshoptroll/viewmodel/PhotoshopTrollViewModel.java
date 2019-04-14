package com.example.piclabs.photoshoptroll.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.piclabs.photoshoptroll.database.UrlDao;
import com.example.piclabs.photoshoptroll.entity.UrlEntity;
import com.example.piclabs.photoshoptroll.repository.PhotoshopTrollRepository;
import java.util.List;

import javax.inject.Inject;

public class PhotoshopTrollViewModel extends ViewModel {
    private PhotoshopTrollRepository photoshopTrollRepository;
    private LiveData<List<UrlEntity>> urlEntitiesLiveData;

    @Inject
    public PhotoshopTrollViewModel(UrlDao urlDao) {
        this.photoshopTrollRepository = new PhotoshopTrollRepository(urlDao);
        this.urlEntitiesLiveData = this.photoshopTrollRepository.getUrls();
    }

    @NonNull
    public LiveData<List<UrlEntity>> getUrlsLiveData() {
        return urlEntitiesLiveData;
    }
}
