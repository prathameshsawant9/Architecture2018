package xyz.pratham.architecture2018.presenter;

/**
 * Created by axisdev on 10/01/18.
 */

public interface BaseView {
    void showMessage(String message);
    void dismissMessage();
    void showToast(String message);
}
