package xyz.pratham.architecture2018.data.source.api;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import xyz.pratham.architecture2018.data.mapper.NewsfeedEntityMapper;
import xyz.pratham.architecture2018.data.model.NewsfeedEntity;
import xyz.pratham.architecture2018.domain.abstraction.FirebaseDatabaseDataSource;
import xyz.pratham.architecture2018.domain.model.Newsfeed;
import xyz.pratham.architecture2018.presenter.Architecture2018;

/**
 * Created by axisdev on 01/02/18.
 */

public class FirebaseDatabaseHelper implements FirebaseDatabaseDataSource{

    DatabaseReference databaseReference;

    @Inject
    public FirebaseDatabaseHelper(Architecture2018 context){
        FirebaseApp.initializeApp(context);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("architectures");
    }

    @Override
    public Observable<List<Newsfeed>> getAllFeeds() {

        return io.reactivex.Observable.create(emitter -> {
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    List<Newsfeed> newsfeeds = new ArrayList<>();
                    for (DataSnapshot data : dataSnapshot.getChildren()){
                        newsfeeds.add(NewsfeedEntityMapper.transform(data.getValue(NewsfeedEntity.class)));
                    }

                    emitter.onNext(newsfeeds);
                    emitter.onComplete();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    if (!emitter.isDisposed())
                        emitter.onError(databaseError.toException());
                }
            });
        });
    }
}
