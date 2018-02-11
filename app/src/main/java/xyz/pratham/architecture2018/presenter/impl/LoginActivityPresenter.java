package xyz.pratham.architecture2018.presenter.impl;

import javax.inject.Inject;

import dagger.Lazy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;
import xyz.pratham.architecture2018.presenter.exception.ErrorMessageFactory;
import xyz.pratham.architecture2018.domain.BaseScheduler;
import xyz.pratham.architecture2018.data.source.api.FirebaseAuthDataSource;
import xyz.pratham.architecture2018.presenter.contract.LoginContract;
import xyz.pratham.architecture2018.presenter.manager.PermissionManager;

/**
 * Created by axisdev on 10/01/18.
 */

public class LoginActivityPresenter implements LoginContract.Presenter{

    @Inject
    BaseScheduler mBaseScheduler;

    @Inject
    Lazy<FirebaseAuthDataSource> mFirebaseAuth;

    LoginContract.Manager loginActivityManager;

    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Inject
    public LoginActivityPresenter(){}

    @Override
    public void setActivityManager(LoginContract.Manager activityManager) {
        this.loginActivityManager = activityManager;
    }

    @Override
    public void start() {
        compositeDisposable.add(
        mFirebaseAuth.get().isUserLoggedIn()
                .observeOn(mBaseScheduler.getUIThread())
                .subscribeOn(mBaseScheduler.getNonUIThread())
                .subscribe(user -> {
                    view().showToast("User Already Logged In !");
                    route().goToMenuScreen( user.getDisplayName());
                }
                ,throwable -> Timber.i(ErrorMessageFactory.getMessage(throwable)))
        );
    }

    @Override
    public void loginUser(String username, String password) {
        String validateMessage = validateLogin(username,password);
        if(!validateMessage.isEmpty()){
            view().showMessage(validateMessage);
            return;
        }

        if(!manager().isNetworkConnected()){
            view().showMessage("Please check your Internet Connection !");
            return;
        }

        view().hideKeyboard();

        Disposable authDisposable =
                mFirebaseAuth.get().loginUser(username,password)
                        .subscribeOn(mBaseScheduler.getNonUIThread())
                        .observeOn(mBaseScheduler.getUIThread())
                        .doOnSubscribe(disposable -> view().showLoader())
                        .subscribe(user -> {
                            view().dismissLoader();
                            route().goToMenuScreen(user.getDisplayName());
                        },throwable -> {
                            view().dismissLoader();
                            view().showMessage(ErrorMessageFactory.getMessage(throwable));
                        });

        compositeDisposable.add(authDisposable);
    }

    private LoginContract.View view(){
        return loginActivityManager.getView();
    }

    private LoginContract.Routing route(){
        return loginActivityManager.getRouting();
    }

    private PermissionManager permission(){
        return loginActivityManager.getPermissionManager();
    }

    private LoginContract.Manager manager(){
        return loginActivityManager;
    }

    @Override
    public void destroy() {
        compositeDisposable.clear();
    }


    private String validateLogin(String username,String password){
        if(username.isEmpty())
            return "Please enter a valid Username !";
        else if (password.isEmpty())
            return "Please enter a valid Password !";
        else
            return "";
    }
}
