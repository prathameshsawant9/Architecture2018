package xyz.pratham.architecture2018.data.source.sharedpref;

/**
 * Created by axisdev on 10/01/18.
 */

public interface SharedPreferenceDataSource {
    void putString(String key, String value);
    String getString(String key, String defaultValue);
    void putInteger(String key,int value);
    int getInt(String key,int defaultValue);
}
