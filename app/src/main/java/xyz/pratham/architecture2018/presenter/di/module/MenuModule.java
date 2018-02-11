package xyz.pratham.architecture2018.presenter.di.module;

import dagger.Binds;
import dagger.Module;
import xyz.pratham.architecture2018.presenter.contract.MenuContract;
import xyz.pratham.architecture2018.presenter.impl.MenuActivtiyPresenter;

/**
 * Created by axisdev on 05/02/18.
 */
@Module
public abstract class MenuModule {

    @Binds
    abstract MenuContract.Presenter providesMenuPresenter(MenuActivtiyPresenter presenter);
}
