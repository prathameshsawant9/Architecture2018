package xyz.pratham.architecture2018.presenter.contract;

import xyz.pratham.architecture2018.presenter.BaseActivityManager;
import xyz.pratham.architecture2018.presenter.BasePresenter;
import xyz.pratham.architecture2018.presenter.BaseRouting;
import xyz.pratham.architecture2018.presenter.BaseView;
import xyz.pratham.architecture2018.presenter.manager.PermissionManager;

/**
 * Created by axisdev on 10/01/18.
 */

public interface LoginContract {
    interface View extends BaseView{
        void showLoader();
        void dismissLoader();
        void hideKeyboard();
    }
    interface Routing extends BaseRouting{
        void goToMenuScreen(String username);
    }
    interface Manager extends BaseActivityManager<Routing,View>{
        boolean isNetworkConnected();
        PermissionManager getPermissionManager();
    }
    interface Presenter extends BasePresenter<View>{
        void loginUser(String username,String password);
        void setActivityManager(Manager activityManager);
    }
}
