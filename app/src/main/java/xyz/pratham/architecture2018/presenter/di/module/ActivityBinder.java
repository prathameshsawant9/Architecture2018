package xyz.pratham.architecture2018.presenter.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import xyz.pratham.architecture2018.presenter.ui.activity.LoginActivity;
import xyz.pratham.architecture2018.presenter.ui.activity.MenuActivity;

/**
 * Created by axisdev on 12/01/18.
 */
@Module
public abstract class ActivityBinder {

    @ContributesAndroidInjector(modules = LoginModule.class)
    abstract LoginActivity injectLoginActivity();

    @ContributesAndroidInjector(modules = MenuModule.class)
    abstract MenuActivity injectMenuActivity();
}
