package xyz.pratham.architecture2018.presenter.exception;

import timber.log.Timber;
import xyz.pratham.architecture2018.data.exception.AuthenticationFailed;
import xyz.pratham.architecture2018.data.exception.UserNotSignedIn;

/**
 * Created by axisdev on 20/01/18.
 */

public class ErrorMessageFactory {
    public static String getMessage(Throwable throwable){
        if(throwable instanceof AuthenticationFailed)
            return "Invalid Username Or Password ";

        if(throwable instanceof UserNotSignedIn)
            return "User Not Signed In !";

        return "Unknown Error : "+ throwable.getClass().getSimpleName();
    }
}
