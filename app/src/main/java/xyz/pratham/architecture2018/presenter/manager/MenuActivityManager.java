package xyz.pratham.architecture2018.presenter.manager;

import xyz.pratham.architecture2018.presenter.contract.MenuContract;
import xyz.pratham.architecture2018.presenter.ui.activity.MenuActivity;

/**
 * Created by axisdev on 03/02/18.
 */

public class MenuActivityManager implements MenuContract.Manager {

    MenuActivity activity;

    public MenuActivityManager(MenuActivity activity){
        this.activity = activity;
    }

    @Override
    public MenuContract.Routing getRouting() {
        return activity;
    }

    @Override
    public MenuContract.View getView() {
        return activity;
    }
}
