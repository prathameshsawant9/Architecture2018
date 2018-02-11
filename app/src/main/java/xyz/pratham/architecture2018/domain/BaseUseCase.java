package xyz.pratham.architecture2018.domain;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by axisdev on 10/01/18.
 */

public abstract class BaseUseCase<  RequestGeneric extends BaseUseCase.Request,
                                    ResponseGeneric extends BaseUseCase.Response> {
    BaseScheduler baseScheduler;

    public BaseUseCase(BaseScheduler baseScheduler){
        this.baseScheduler = baseScheduler;
    }

    protected abstract Observable<ResponseGeneric> buildUseCase(RequestGeneric requestGeneric);

    public Observer<ResponseGeneric> execute(RequestGeneric requestGeneric, Observer<ResponseGeneric> observer){
            return  buildUseCase(requestGeneric)
                        .subscribeOn(baseScheduler.getUIThread())
                        .observeOn(baseScheduler.getUIThread())
                        .subscribeWith(observer);
    }

    public interface Response{}
    public interface Request{}
}
