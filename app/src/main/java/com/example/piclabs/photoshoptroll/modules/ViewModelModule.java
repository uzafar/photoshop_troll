package com.example.piclabs.photoshoptroll.modules;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.piclabs.photoshoptroll.factories.ViewModelFactory;
import com.example.piclabs.photoshoptroll.factories.ViewModelKey;
import com.example.piclabs.photoshoptroll.viewmodel.PhotoshopTrollViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);


    /*
     * This method basically says
     * inject this object into a Map using the @IntoMap annotation,
     * with the PhotoshopTrollViewModel.class as key,
     * and a Provider that will build a PhotoshopTrollViewModel
     * object.
     *
     * */

    @Binds
    @IntoMap
    @ViewModelKey(PhotoshopTrollViewModel.class)
    protected abstract ViewModel photoshopTrollViewModel(PhotoshopTrollViewModel photoshopTrollViewModel);
}
