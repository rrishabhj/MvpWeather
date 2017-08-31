package rishabh.mvpandroid;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import rishabh.mvpandroid.di.components.ApplicationComponent;
import rishabh.mvpandroid.di.components.DaggerApplicationComponent;
import rishabh.mvpandroid.di.modules.ApplicationModule;
import rishabh.mvpandroid.di.modules.NetworkModule;
import rishabh.mvpandroid.di.qualifiers.ApplicationContext;



/**
 * 19/5/17.
 */

public class MvpAndroid extends Application {

    private ApplicationComponent mApplicationComponent;

    @Inject
    @ApplicationContext
    Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule())
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

}
