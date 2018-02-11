package xyz.pratham.architecture2018.data.source.api;

import com.google.firebase.auth.FirebaseUser;

import io.reactivex.Maybe;
import io.reactivex.Single;

/**
 * Created by axisdev on 10/01/18.
 */

public interface FirebaseAuthDataSource {
    Single<FirebaseUser> loginUser(String username, String password);
    Maybe<FirebaseUser> isUserLoggedIn();
    void signOut();
}
