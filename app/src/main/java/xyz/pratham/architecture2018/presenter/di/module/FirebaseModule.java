package xyz.pratham.architecture2018.presenter.di.module;

import dagger.Binds;
import dagger.Module;
import xyz.pratham.architecture2018.data.source.api.FirebaseAuthentication;
import xyz.pratham.architecture2018.data.source.api.FirebaseAuthDataSource;
import xyz.pratham.architecture2018.data.source.api.FirebaseDatabaseHelper;
import xyz.pratham.architecture2018.domain.abstraction.FirebaseDatabaseDataSource;

/**
 * Created by axisdev on 18/01/18.
 */
@Module
public abstract class FirebaseModule {

    @Binds
    abstract FirebaseAuthDataSource providesFirebaseAuthentication(FirebaseAuthentication firebaseAuthentication);


    @Binds
    abstract FirebaseDatabaseDataSource providesFirebaseDataSource(FirebaseDatabaseHelper firebaseDatabaseHelper);
}
