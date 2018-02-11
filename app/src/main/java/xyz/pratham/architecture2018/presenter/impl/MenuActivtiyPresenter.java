package xyz.pratham.architecture2018.presenter.impl;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;
import xyz.pratham.architecture2018.data.source.api.FirebaseAuthentication;
import xyz.pratham.architecture2018.domain.usecase.GetNewsfeedCase;
import xyz.pratham.architecture2018.presenter.contract.MenuContract;
import xyz.pratham.architecture2018.presenter.mapper.NewsfeedModelMapper;

/**
 * Created by axisdev on 05/02/18.
 */

public class MenuActivtiyPresenter implements MenuContract.Presenter{

    @Inject
    GetNewsfeedCase newsfeedCase;

    @Inject
    FirebaseAuthentication firebaseAuthentication;

    CompositeDisposable compositeDisposable = new CompositeDisposable();
    MenuContract.Manager menuActivtiyManager;

    @Inject
    public MenuActivtiyPresenter(){}

    @Override
    public void setActivityManager(MenuContract.Manager activityManager) {
        this.menuActivtiyManager = activityManager;
    }

    @Override
    public void start() {
        showNewsFeed();
    }

    @Override
    public void destroy() {
        compositeDisposable.clear();
    }

    @Override
    public void showNewsFeed() {
        Timber.i( "showNewsFeed: " + newsfeedCase);
        Timber.i( "showFirebaseAuth: " + firebaseAuthentication);

        GetNewsfeedCase.RequestValues requestValues = new GetNewsfeedCase.RequestValues();
        newsfeedCase.execute(requestValues,getNewsfeedsObserver());
    }

    @Override
    public void updateTitle(String username) {
        view().setTitle("Welcome "+username);
    }

    @Override
    public void signOut() {
        firebaseAuthentication.signOut();
        route().exit();
    }

    private MenuContract.Manager manager(){
        return menuActivtiyManager;
    }

    private MenuContract.View view(){
        return menuActivtiyManager.getView();
    }

    private MenuContract.Routing route(){
        return menuActivtiyManager.getRouting();
    }

    private Observer<GetNewsfeedCase.ResponseValues> getNewsfeedsObserver(){
        return new Observer<GetNewsfeedCase.ResponseValues>() {
            @Override
            public void onSubscribe(Disposable d) {
                compositeDisposable.add(d);
            }

            @Override
            public void onNext(GetNewsfeedCase.ResponseValues responseValues) {
                view().showNewsFeed( NewsfeedModelMapper.transform( responseValues.getNewsfeeds() ) );
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
