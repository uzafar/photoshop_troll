package com.example.piclabs.photoshoptroll.modules;

import com.example.piclabs.photoshoptroll.fragments.PhotoshopTrollViewFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentModule {

    @ContributesAndroidInjector()
    abstract PhotoshopTrollViewFragment contributePhotoshopTrollViewFragment();
}