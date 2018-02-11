package xyz.pratham.architecture2018.presenter;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tbruyelle.rxpermissions2.RxPermissions;

import java.sql.Time;

import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;
import xyz.pratham.architecture2018.R;

/**
 * Created by axisdev on 10/01/18.
 */

public class BaseActivity extends DaggerAppCompatActivity implements BaseView{

    AlertDialog alertDialog;

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        dismissMessage();

        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(getApplicationContext().getString(R.string.app_name));
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                (dialog, which) -> dismissMessage());
        alertDialog.show();

    }

    @Override
    public void dismissMessage() {
        try{
            alertDialog.dismiss();
        }
        catch (Exception e){}
    }
}
