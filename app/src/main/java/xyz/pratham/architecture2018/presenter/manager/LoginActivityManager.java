package xyz.pratham.architecture2018.presenter.manager;

import android.content.Context;
import android.net.ConnectivityManager;

import xyz.pratham.architecture2018.presenter.contract.LoginContract;
import xyz.pratham.architecture2018.presenter.ui.activity.LoginActivity;

/**
 * Created by axisdev on 24/01/18.
 */

public class LoginActivityManager implements LoginContract.Manager{

    LoginActivity context;

    public LoginActivityManager(LoginActivity context){
        this.context = context;
    }

    @Override
    public LoginContract.Routing getRouting() {
        return context;
    }

    @Override
    public LoginContract.View getView() {
        return context;
    }

    @Override
    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }

    @Override
    public PermissionManager getPermissionManager() {
        return new PermissionManagerImp(context);
    }
}
