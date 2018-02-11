package xyz.pratham.architecture2018.domain.usecase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import xyz.pratham.architecture2018.domain.BaseScheduler;
import xyz.pratham.architecture2018.domain.BaseUseCase;
import xyz.pratham.architecture2018.domain.abstraction.FirebaseDatabaseDataSource;
import xyz.pratham.architecture2018.domain.model.Newsfeed;

/**
 * Created by axisdev on 03/02/18.
 */

public class GetNewsfeedCase extends BaseUseCase<GetNewsfeedCase.RequestValues,GetNewsfeedCase.ResponseValues>{

    @Inject
    FirebaseDatabaseDataSource firebaseDatabaseDataSource;

    @Inject
    public GetNewsfeedCase(BaseScheduler baseScheduler){
        super(baseScheduler);
    }

    @Override
    protected Observable<ResponseValues> buildUseCase(RequestValues requestValues) {
        return firebaseDatabaseDataSource.getAllFeeds()
                .map(newsfeeds -> new ResponseValues(newsfeeds));
    }

    public static final class RequestValues implements BaseUseCase.Request{
        public RequestValues(){}
    }

    public static final class ResponseValues implements BaseUseCase.Response{
        List<Newsfeed> newsfeeds;

        public ResponseValues(List<Newsfeed> newsfeeds){
            this.newsfeeds = newsfeeds;
        }

        public List<Newsfeed> getNewsfeeds() {
            return newsfeeds;
        }
    }
}
