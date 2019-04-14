package com.example.piclabs.photoshoptroll.modules;

import com.example.piclabs.photoshoptroll.activities.PhotoshopTrollActivity;
import com.example.piclabs.photoshoptroll.activities.PhotoshopTrollSplashScreenActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector()
    abstract PhotoshopTrollSplashScreenActivity contributePhotoshopTrollSplashScreenActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract PhotoshopTrollActivity contributePhotoshopTrollActivity();
}