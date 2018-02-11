package xyz.pratham.architecture2018.presenter.di.module;

import dagger.Binds;
import dagger.Module;
import xyz.pratham.architecture2018.data.source.api.RemoteRepositoryDataSource;
import xyz.pratham.architecture2018.data.source.api.RetrofitAPI;
import xyz.pratham.architecture2018.data.source.database.LocalRepositoryDataSource;
import xyz.pratham.architecture2018.data.source.database.SQLRoomRepository;
import xyz.pratham.architecture2018.data.source.sharedpref.SharedPreferenceDataSource;
import xyz.pratham.architecture2018.data.source.sharedpref.SharedPreferenceRepository;
import xyz.pratham.architecture2018.presenter.di.scope.ApplicationScope;

/**
 * Created by axisdev on 18/01/18.
 */
@Module
public abstract class DataSourceModule {

    @Binds
    @ApplicationScope
    abstract SharedPreferenceDataSource providesSharedPreference(SharedPreferenceRepository sharedPreferenceRepository);

    @Binds
    @ApplicationScope
    abstract LocalRepositoryDataSource providesLocalRepository(SQLRoomRepository sqlRoomRepository);

    @Binds
    @ApplicationScope
    abstract RemoteRepositoryDataSource providesRemoteRepository(RetrofitAPI retrofitAPI);
}
