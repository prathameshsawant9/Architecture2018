package xyz.pratham.architecture2018.presenter;

/**
 * Created by axisdev on 24/01/18.
 */

public interface BaseActivityManager<ROUTE extends BaseRouting, VIEW extends BaseView> {
    ROUTE getRouting();
    VIEW getView();
}
