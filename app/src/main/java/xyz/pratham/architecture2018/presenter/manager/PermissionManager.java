package xyz.pratham.architecture2018.presenter.manager;


import com.tbruyelle.rxpermissions2.Permission;

import io.reactivex.Observable;

/**
 * Created by axisdev on 17/01/18.
 */

public interface PermissionManager {
    Observable<Boolean> requestPermission(String permission);
    Observable<Permission> requestPermission(String[] permissions);

    interface Permission{
        boolean isGranted();
        boolean showRationale();
        boolean isDenied();
    }
}
