package xyz.pratham.architecture2018.presenter.di.module;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import xyz.pratham.architecture2018.data.manager.BaseSchedulerManager;
import xyz.pratham.architecture2018.domain.BaseScheduler;
import xyz.pratham.architecture2018.presenter.di.scope.ApplicationScope;

/**
 * Created by axisdev on 18/01/18.
 */
@Module
public abstract class SchedulerModule {

    @Binds
    @ApplicationScope
    abstract BaseScheduler provideBaseScheduler(BaseSchedulerManager baseSchedulerManager);
}
