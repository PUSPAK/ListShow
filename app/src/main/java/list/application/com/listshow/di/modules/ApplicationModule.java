package list.application.com.listshow.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Puspak on 30/07/18.
 */

@Module
public class ApplicationModule {

    private Application app;

    public ApplicationModule(Application app){
        this.app = app;
    }


    @Provides
    @Singleton
    Context provideContext(){
        return app;
    }

}
