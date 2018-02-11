package xyz.pratham.architecture2018.presenter.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by axisdev on 18/01/18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {}
