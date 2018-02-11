package xyz.pratham.architecture2018.presenter.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import xyz.pratham.architecture2018.R;
import xyz.pratham.architecture2018.databinding.ActivityLoginBinding;
import xyz.pratham.architecture2018.presenter.BaseActivity;
import xyz.pratham.architecture2018.presenter.contract.LoginContract;
import xyz.pratham.architecture2018.presenter.manager.LoginActivityManager;
import xyz.pratham.architecture2018.presenter.impl.LoginActivityPresenter;

/**
 * Created by axisdev on 10/01/18.
 */

public class LoginActivity extends BaseActivity implements LoginContract.View,LoginContract.Routing{

    @Inject
    LoginActivityPresenter loginActivityPresenter;
    ActivityLoginBinding activityLoginBinding;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        LoginActivityManager loginActivityManagerImp = new LoginActivityManager(this);
        loginActivityPresenter.setActivityManager(loginActivityManagerImp);

        compositeDisposable.add(
        RxView.clicks(activityLoginBinding.login)
                .debounce(500,TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    login();
                })
        );

        activityLoginBinding.password.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                login();
                return true;
            }
            return false;
        });

        loginActivityPresenter.start();
    }


    private void login(){
        String username = activityLoginBinding.username.getText().toString();
        String password = activityLoginBinding.password.getText().toString();
        loginActivityPresenter.loginUser(username,password);
    }

    @Override
    public void showLoader() {
        activityLoginBinding.progressBar.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    @Override
    public void dismissLoader() {
        activityLoginBinding.progressBar.setVisibility(View.GONE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginActivityPresenter.destroy();
        compositeDisposable.clear();
    }

    @Override
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void goToMenuScreen(String username) {
        Intent intent = new Intent(this,MenuActivity.class);
        intent.putExtra("username",username);
        startActivityForResult(intent,101);
    }
}
