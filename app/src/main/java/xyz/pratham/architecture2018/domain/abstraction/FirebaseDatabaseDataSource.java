package xyz.pratham.architecture2018.domain.abstraction;


import java.util.List;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import xyz.pratham.architecture2018.domain.model.Newsfeed;

/**
 * Created by axisdev on 01/02/18.
 */

public interface FirebaseDatabaseDataSource {
    Observable<List<Newsfeed>> getAllFeeds();
}
