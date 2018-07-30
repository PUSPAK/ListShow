package list.application.com.listshow;

import android.app.Application;

import list.application.com.listshow.di.components.ApplicationComponent;
import list.application.com.listshow.di.components.DaggerApplicationComponent;
import list.application.com.listshow.di.modules.ApplicationModule;

/**
 * Created by Puspak on 30/07/18.
 */
public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                                .builder()
                                .build();

    }


}
