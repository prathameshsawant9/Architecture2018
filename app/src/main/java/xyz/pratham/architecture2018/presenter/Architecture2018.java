package xyz.pratham.architecture2018.presenter;

import android.app.Application;
import android.util.Log;

import com.google.firebase.FirebaseApp;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import timber.log.Timber;
import xyz.pratham.architecture2018.BuildConfig;
import xyz.pratham.architecture2018.presenter.di.AppComponent;
import xyz.pratham.architecture2018.presenter.di.DaggerAppComponent;

/**
 * Created by axisdev on 10/01/18.
 */

public class Architecture2018 extends DaggerApplication{
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().attachApplicationContext(this).build();
        appComponent.inject(this);
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG)
            Timber.plant(new Timber.DebugTree());
    }
}
