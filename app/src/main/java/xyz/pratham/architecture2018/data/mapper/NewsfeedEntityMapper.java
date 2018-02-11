package xyz.pratham.architecture2018.data.mapper;

import xyz.pratham.architecture2018.data.model.NewsfeedEntity;
import xyz.pratham.architecture2018.domain.model.Newsfeed;

/**
 * Created by axisdev on 01/02/18.
 */

public class NewsfeedEntityMapper {
    public static Newsfeed transform(NewsfeedEntity newsfeedEntity){
        Newsfeed newsfeed = new Newsfeed();
        newsfeed.setMessage(newsfeedEntity.getMessage());
        newsfeed.setTitle(newsfeedEntity.getTitle());
        return newsfeed;
    }
}
