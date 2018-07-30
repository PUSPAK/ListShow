package list.application.com.listshow.ui.main;


import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import list.application.com.listshow.models.Response;
import list.application.com.listshow.network.NetworkClient;
import list.application.com.listshow.network.NetworkInterface;


public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mainViewInterface;
    private String TAG = "MainPresenter";

    public MainPresenter(MainViewInterface mainViewInterface) {
        this.mainViewInterface = mainViewInterface;
    }
//Getting Results

    @Override
    public void getItems(SwipeRefreshLayout mSwipeRefreshLayout) {
        getObservable().subscribeWith(getObserver(mSwipeRefreshLayout));
    }
//Getting RX Observable Object

    public Observable<Response> getObservable(){
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                            .getListItems()
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread());
    }
//Getting RX Observer Object

    public DisposableObserver<Response> getObserver(final SwipeRefreshLayout mSwipeRefreshLayout){
        return new DisposableObserver<Response>() {

            @Override
            public void onNext(@NonNull Response movieResponse) {
                mainViewInterface.displayItems(movieResponse);
                mSwipeRefreshLayout.setRefreshing(false);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG,"Error"+e);
                e.printStackTrace();
                mainViewInterface.displayError("Error fetching Movie Data");
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onComplete() {
                Log.d(TAG,"Completed");
                mainViewInterface.hideProgressBar();
                mSwipeRefreshLayout.setRefreshing(false);

            }
        };
    }
}
