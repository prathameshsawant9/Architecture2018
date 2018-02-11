package xyz.pratham.architecture2018.presenter.contract;

import java.util.List;

import xyz.pratham.architecture2018.presenter.BaseActivityManager;
import xyz.pratham.architecture2018.presenter.BasePresenter;
import xyz.pratham.architecture2018.presenter.BaseRouting;
import xyz.pratham.architecture2018.presenter.BaseView;
import xyz.pratham.architecture2018.presenter.model.NewsfeedModel;

/**
 * Created by axisdev on 25/01/18.
 */

public interface MenuContract {
    interface View extends BaseView{
        void showNewsFeed(List<NewsfeedModel> newsfeeds);
        void setTitle(String title);
    }
    interface Routing extends BaseRouting{
        void exit();
        void goToLoginActivity();
    }
    interface Manager extends BaseActivityManager<Routing,View>{

    }
    interface Presenter extends BasePresenter<View>{
        void setActivityManager(Manager activityManager);
        void showNewsFeed();
        void updateTitle(String username);
        void signOut();
    }
}
