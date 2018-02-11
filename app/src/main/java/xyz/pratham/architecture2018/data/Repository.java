package xyz.pratham.architecture2018.data;

import javax.inject.Inject;

import dagger.Lazy;
import xyz.pratham.architecture2018.data.source.api.RemoteRepositoryDataSource;
import xyz.pratham.architecture2018.data.source.database.LocalRepositoryDataSource;
import xyz.pratham.architecture2018.data.source.sharedpref.SharedPreferenceDataSource;

/**
 * Created by axisdev on 10/01/18.
 */

public class Repository {

    @Inject
    Lazy<RemoteRepositoryDataSource> remoteRepositoryDataSourceLazy;

    @Inject
    LocalRepositoryDataSource localRepositoryDataSource;

    @Inject
    SharedPreferenceDataSource sharedPreferenceDataSource;

    @Inject
    public Repository(){
    }
}
