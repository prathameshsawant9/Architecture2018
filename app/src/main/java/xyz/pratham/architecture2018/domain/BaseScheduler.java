package xyz.pratham.architecture2018.domain;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by axisdev on 10/01/18.
 */

public interface BaseScheduler {
    Scheduler getUIThread();
    Scheduler getNonUIThread();
}
