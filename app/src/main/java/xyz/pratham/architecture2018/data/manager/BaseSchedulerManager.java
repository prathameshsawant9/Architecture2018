package xyz.pratham.architecture2018.data.manager;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xyz.pratham.architecture2018.domain.BaseScheduler;

/**
 * Created by axisdev on 17/01/18.
 */

public class BaseSchedulerManager implements BaseScheduler{

    @Inject
    BaseSchedulerManager(){}

    @Override
    public Scheduler getUIThread() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler getNonUIThread() {
        return Schedulers.io();
    }
}
