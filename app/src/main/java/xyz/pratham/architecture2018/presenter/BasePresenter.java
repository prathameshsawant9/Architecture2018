package xyz.pratham.architecture2018.presenter;

/**
 * Created by axisdev on 10/01/18.
 */

public interface BasePresenter<T extends BaseView> {
    void start();
    void destroy();
    // void attachView(T view);
    // void detachView();
}
