package com.example.piclabs.photoshoptroll.fragments;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.piclabs.photoshoptroll.R;
import com.example.piclabs.photoshoptroll.entity.UrlEntity;
import com.example.piclabs.photoshoptroll.factories.ViewModelFactory;
import com.example.piclabs.photoshoptroll.viewmodel.PhotoshopTrollViewModel;
import com.veinhorn.scrollgalleryview.MediaInfo;
import com.veinhorn.scrollgalleryview.ScrollGalleryView;
import com.veinhorn.scrollgalleryview.builder.GalleryBuilder;
import com.veinhorn.scrollgalleryview.builder.GallerySettings;
import com.veinhorn.scrollgalleryview.loader.picasso.PicassoImageLoader;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;

public class PhotoshopTrollViewFragment extends Fragment {

    private final String SELECTED_IMAGE = "selected_image";

    @Inject
    ViewModelFactory viewModelFactory;

    private PhotoshopTrollViewModel photoshopTrollViewModel;
    private ScrollGalleryView scrollGalleryView;
    private GalleryBuilder galleryBuilder;

    private int selectedImage;

    public PhotoshopTrollViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidSupportInjection.inject(this);
        photoshopTrollViewModel = ViewModelProviders.of(this, viewModelFactory).get(PhotoshopTrollViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle savedState = savedInstanceState;
        if (scrollGalleryView == null) {
            galleryBuilder = ScrollGalleryView
                    .from((ScrollGalleryView) view.findViewById(R.id.scroll_gallery_view))
                    .settings(
                            GallerySettings
                                    .from(getChildFragmentManager())
                                    .thumbnailSize(100)
                                    .enableZoom(true)
                                    .build()
                    );

            photoshopTrollViewModel.getUrlsLiveData().observe(this, new Observer<List<UrlEntity>>() {
                @Override
                public void onChanged(@Nullable List<UrlEntity> urlEntities) {
                    if (urlEntities == null) {
                        return;
                    }

                    if (scrollGalleryView == null) {
                        for (UrlEntity urlEntity : urlEntities) {
                            galleryBuilder.add(
                                    MediaInfo.mediaLoader(
                                            new PicassoImageLoader(urlEntity.getUrl(), 100, 100), "")
                            );
                        }

                        scrollGalleryView = galleryBuilder.build();
                        scrollGalleryView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                            @Override
                            public void onPageScrolled(int i, float v, int i1) { }

                            @Override
                            public void onPageSelected(int i) {
                                selectedImage = i;
                            }

                            @Override
                            public void onPageScrollStateChanged(int i) { }
                        });
                    }

                    if (savedState != null) {
                        scrollGalleryView.setCurrentItem(savedState.getInt(SELECTED_IMAGE, 0));
                    }
                }
            });
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SELECTED_IMAGE, selectedImage);
    }
}
