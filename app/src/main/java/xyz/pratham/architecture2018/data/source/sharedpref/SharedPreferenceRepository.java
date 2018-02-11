package xyz.pratham.architecture2018.data.source.sharedpref;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by axisdev on 10/01/18.
 */

@Singleton
public class SharedPreferenceRepository implements SharedPreferenceDataSource{

    String sharedPreferenceFileName = "Architecture2018";
    SharedPreferences sharedPreferences;

    @Inject
    public SharedPreferenceRepository(Application application){
        sharedPreferences = application.getSharedPreferences(sharedPreferenceFileName, Context.MODE_PRIVATE);
    }

    @Override
    public void putString(String key, String value) {
        sharedPreferences.edit().putString(key,value).commit();
    }

    @Override
    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key,defaultValue);
    }

    @Override
    public void putInteger(String key, int value) {
        sharedPreferences.edit().putInt(key,value).commit();
    }

    @Override
    public int getInt(String key, int defaultValue) {
        return sharedPreferences.getInt(key,defaultValue);
    }
}
