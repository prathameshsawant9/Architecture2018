package xyz.pratham.architecture2018.presenter.di;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;
import xyz.pratham.architecture2018.presenter.Architecture2018;
import xyz.pratham.architecture2018.presenter.di.module.ActivityBinder;
import xyz.pratham.architecture2018.presenter.di.module.DataSourceModule;
import xyz.pratham.architecture2018.presenter.di.module.FirebaseModule;
import xyz.pratham.architecture2018.presenter.di.module.SchedulerModule;
import xyz.pratham.architecture2018.presenter.di.scope.ApplicationScope;

/**
 * Created by axisdev on 10/01/18.
 */
@ApplicationScope
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidInjectionModule.class,
        SchedulerModule.class,
        FirebaseModule.class,
        DataSourceModule.class,
        ActivityBinder.class
})
public interface AppComponent extends AndroidInjector<DaggerApplication>
{
    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder{

        @BindsInstance
        AppComponent.Builder attachApplicationContext(Architecture2018 application);
        AppComponent build();
    }
}
