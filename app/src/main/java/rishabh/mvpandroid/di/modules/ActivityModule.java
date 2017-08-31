package rishabh.mvpandroid.di.modules;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import rishabh.mvpandroid.data.Model.TvModel;
import rishabh.mvpandroid.di.qualifiers.ActivityContext;
import rishabh.mvpandroid.di.scopes.ActivityScope;
import rishabh.mvpandroid.ui.SignUp.SignUpMvpPresenter;
import rishabh.mvpandroid.ui.SignUp.SignUpMvpView;
import rishabh.mvpandroid.ui.SignUp.SignUpPresenter;
import rishabh.mvpandroid.ui.CommonFragmentAdapter;

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
    SignUpMvpPresenter<SignUpMvpView> provideWeatherPresenter(SignUpPresenter<SignUpMvpView> signUpPresenter) {
        return signUpPresenter;
    }

    //@ActivityScope
    //@Provides
    //MainMvpPresenter<MainMvpView> provideMainPresenter(MainPresenter<MainMvpView> mainPresenter) {
    //    return mainPresenter;
    //}
    //
    //@ActivityScope
    //@Provides
    //DetailMvpPresenter<DetailMvpView> provideDetailPresenter(DetailPresenter<DetailMvpView> detailPresenter) {
    //    return detailPresenter;
    //}

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    //@Provides
    //CommonFragmentAdapter provideTvShowsAdapter() {
    //    return new CommonFragmentAdapter(new ArrayList<TvModel>());
    //}
    //
    //@Provides
    //PopularShowsMvpPresenter<PopularShowsMvpView> provideTvShowsPresenter(PopularShowsPresenter<PopularShowsMvpView> popularTvShowsPresenter) {
    //    return popularTvShowsPresenter;
    //}
    //
    //@Provides
    //TopRatedShowsMvpPresenter<TopRatedShowsMvpView> provideTopRatedPresenter(TopRatedShowsPresenter<TopRatedShowsMvpView> topRatedShowsPresenter) {
    //    return topRatedShowsPresenter;
    //}
}
