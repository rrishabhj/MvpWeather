package rishabh.mvpandroid.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import rishabh.mvpandroid.di.qualifiers.ActivityContext;
import rishabh.mvpandroid.di.scopes.ActivityScope;
import rishabh.mvpandroid.ui.WeatherMain.WeatherMvpPresenter;
import rishabh.mvpandroid.ui.WeatherMain.WeatherMvpView;
import rishabh.mvpandroid.ui.WeatherMain.WeatherPresenter;

/**
 * 19/5/17.
 */

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @ActivityContext
    @ActivityScope
    @Provides
    Context provideContext() {
        return activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity() {
        return activity;
    }

    @ActivityScope
    @Provides
    WeatherMvpPresenter<WeatherMvpView> provideWeatherPresenter(WeatherPresenter<WeatherMvpView> weatherPresenter) {
        return weatherPresenter;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
