package xyz.pratham.architecture2018.presenter.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import xyz.pratham.architecture2018.domain.model.Newsfeed;
import xyz.pratham.architecture2018.presenter.model.NewsfeedModel;

/**
 * Created by axisdev on 05/02/18.
 */

public class NewsfeedModelMapper {
    public static NewsfeedModel transform(Newsfeed newsfeed){
        NewsfeedModel newsfeedModel = new NewsfeedModel();
        newsfeedModel.setMessage(newsfeed.getMessage());
        newsfeedModel.setTitle(newsfeed.getTitle());

        return newsfeedModel;
    }

    public static List<NewsfeedModel> transform(List<Newsfeed> newsfeedList){
        List<NewsfeedModel> newsfeedsModels = new ArrayList<>();

        for (Newsfeed newsfeed : newsfeedList)
            newsfeedsModels.add( NewsfeedModelMapper.transform( newsfeed ) );

        return newsfeedsModels;
    }
}
