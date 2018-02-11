package xyz.pratham.architecture2018.data.source.database;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by axisdev on 10/01/18.
 */

public class SQLRoomRepository implements LocalRepositoryDataSource {
    Application application;

    @Inject
    public SQLRoomRepository(Application application){

    }
}
