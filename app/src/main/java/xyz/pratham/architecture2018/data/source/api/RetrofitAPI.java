package xyz.pratham.architecture2018.data.source.api;

import android.app.Application;

import javax.inject.Inject;

/**
 * Created by axisdev on 10/01/18.
 */

public class RetrofitAPI  implements RemoteRepositoryDataSource {

    Application application;

    @Inject
    public RetrofitAPI(Application application){

    }
}
