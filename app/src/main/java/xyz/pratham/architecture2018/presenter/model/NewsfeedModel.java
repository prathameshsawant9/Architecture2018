package xyz.pratham.architecture2018.presenter.model;

/**
 * Created by axisdev on 03/02/18.
 */

public class NewsfeedModel {
    String title;
    String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }
}
