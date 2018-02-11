package xyz.pratham.architecture2018.data.source.api;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.inject.Inject;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.Single;
import xyz.pratham.architecture2018.data.exception.AuthenticationFailed;
import xyz.pratham.architecture2018.data.exception.UserNotSignedIn;
import xyz.pratham.architecture2018.presenter.Architecture2018;

/**
 * Created by axisdev on 11/01/18.
 */

public class FirebaseAuthentication implements FirebaseAuthDataSource{

    private FirebaseAuth mFirebaseAuth;

    @Inject
    public FirebaseAuthentication(Architecture2018 applicationContext){
        FirebaseApp.initializeApp(applicationContext);
        mFirebaseAuth = FirebaseAuth.getInstance();
    }

    @Override
    public Single<FirebaseUser> loginUser(String username, String password) {
        return Single.create(emitter -> {
            mFirebaseAuth.signInWithEmailAndPassword(username,password)
                    .addOnCompleteListener(task -> {
                        try{
                            if(task.isSuccessful())
                                emitter.onSuccess(mFirebaseAuth.getCurrentUser());
                            else
                                // Just to avoid Undeliverable Exception
                                if(!emitter.isDisposed())
                                    emitter.onError(new AuthenticationFailed());
                        }
                        catch (Exception e){
                            if(!emitter.isDisposed())
                                emitter.onError(e);
                        }
                    });
        });
    }

    @Override
    public Maybe<FirebaseUser> isUserLoggedIn() {
        return Maybe.create(new MaybeOnSubscribe<FirebaseUser>() {
            @Override
            public void subscribe(MaybeEmitter<FirebaseUser> emitter) throws Exception {
                FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser();
                if(firebaseUser != null)
                    emitter.onSuccess(firebaseUser);
                else
                    if(!emitter.isDisposed())
                        emitter.onError(new UserNotSignedIn());
            }
        });
        // .map(UserEntityMapper::transform);
    }

    @Override
    public void signOut() {
        mFirebaseAuth.signOut();
    }
}
