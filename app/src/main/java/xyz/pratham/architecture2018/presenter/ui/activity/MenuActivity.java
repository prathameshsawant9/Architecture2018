package xyz.pratham.architecture2018.presenter.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import xyz.pratham.architecture2018.R;
import xyz.pratham.architecture2018.databinding.ActivityMenuBinding;
import xyz.pratham.architecture2018.presenter.BaseActivity;
import xyz.pratham.architecture2018.presenter.contract.MenuContract;
import xyz.pratham.architecture2018.presenter.manager.MenuActivityManager;
import xyz.pratham.architecture2018.presenter.model.NewsfeedModel;

public class MenuActivity extends BaseActivity implements MenuContract.Routing,MenuContract.View{

    @Inject
    MenuContract.Presenter menuActivtiyPresenter;

    ActivityMenuBinding activityMenuBinding;
    CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMenuBinding = DataBindingUtil.setContentView(this,R.layout.activity_menu);

        menuActivtiyPresenter.setActivityManager(new MenuActivityManager(this));

        disposable.add(
        RxView.clicks(activityMenuBinding.signout)
                .debounce(500, TimeUnit.MILLISECONDS)
                .subscribe(o -> menuActivtiyPresenter.signOut()));

        String username = getIntent().getExtras().getString("username","");
        menuActivtiyPresenter.updateTitle(username);
    }

    @Override
    public void setTitle(String title) {
        activityMenuBinding.title.setText(title);
    }

    @Override
    protected void onResume() {
        super.onResume();
        menuActivtiyPresenter.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        menuActivtiyPresenter.destroy();
        disposable.clear();
    }

    @Override
    public void showNewsFeed(List<NewsfeedModel> newsfeeds) {
        NewsfeedAdapter newsfeedAdapter = new NewsfeedAdapter(this,newsfeeds);
        activityMenuBinding.newsfeed.setAdapter(newsfeedAdapter);
    }

    @Override
    public void exit() {
        finish();
    }

    @Override
    public void goToLoginActivity() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public class NewsfeedAdapter extends ArrayAdapter<NewsfeedModel>{

        List<NewsfeedModel> newsfeeds;
        LayoutInflater layoutInflater;

        public NewsfeedAdapter(@NonNull Context context, List<NewsfeedModel> newsfeeds) {
            super(context, 0);
            this.newsfeeds = newsfeeds;
            this.layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return newsfeeds.size();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            NewsfeedModel newsfeedModel = newsfeeds.get(position);

            if(convertView == null)
                convertView = this.layoutInflater.inflate(R.layout.row_newsfeed,parent,false);

            ((TextView)convertView.findViewById(R.id.name)).setText(newsfeedModel.getTitle());

            return convertView;
        }
    }
}
