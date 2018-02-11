package xyz.pratham.architecture2018.presenter.manager;

import android.app.Activity;

import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.Observable;
import xyz.pratham.architecture2018.presenter.manager.PermissionManager;

/**
 * Created by axisdev on 17/01/18.
 */

public class PermissionManagerImp implements PermissionManager {

    RxPermissions rxPermissions;

    public PermissionManagerImp(Activity activity){
        rxPermissions = new RxPermissions(activity);
    }

    @Override
    public Observable<Permission> requestPermission(String[] permissions) {
        return rxPermissions.requestEach(permissions)
                .map(permission ->
                        new PermissionModel(permission.granted, permission.shouldShowRequestPermissionRationale, !permission.granted)
                );
    }

    @Override
    public Observable<Boolean> requestPermission(String permission) {
        return rxPermissions.request(permission);
    }


    public static class PermissionModel implements PermissionManager.Permission{

        boolean isGranted,showRationale,isDenied;

        public PermissionModel(boolean isGranted, boolean showRationale, boolean isDenied){
            this.isGranted = isGranted;
            this.showRationale = showRationale;
            this.isDenied = isDenied;
        }

        @Override
        public boolean isGranted() {
            return isGranted;
        }

        @Override
        public boolean showRationale() {
            return showRationale;
        }

        @Override
        public boolean isDenied() {
            return isDenied;
        }
    }
}
