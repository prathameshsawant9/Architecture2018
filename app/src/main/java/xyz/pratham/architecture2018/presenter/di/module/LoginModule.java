package xyz.pratham.architecture2018.presenter.di.module;

import dagger.Binds;
import dagger.Module;
import xyz.pratham.architecture2018.presenter.contract.LoginContract;
import xyz.pratham.architecture2018.presenter.impl.LoginActivityPresenter;

/**
 * Created by axisdev on 17/01/18.
 */
@Module
public abstract class LoginModule {

    @Binds
    abstract LoginContract.Presenter providesLoginPresenter(LoginActivityPresenter presenter);
}
