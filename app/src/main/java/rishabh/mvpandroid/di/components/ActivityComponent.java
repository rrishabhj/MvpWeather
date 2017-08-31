package rishabh.mvpandroid.di.components;

import dagger.Component;
import rishabh.mvpandroid.di.modules.ActivityModule;
import rishabh.mvpandroid.ui.SignUp.SignUpActivity;
import rishabh.mvpandroid.di.scopes.ActivityScope;

/**
 * 19/5/17.
 */

@ActivityScope
@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
public interface ActivityComponent {

//    void injectMainActivity(MainActivity mainActivity);

    void injectLoginActivity(SignUpActivity mainActivity);

//    void injectPopularTvShows(PopularShows popularTvShows);

//    void injectTopRatedTvShows(TopRatedShows topRatedShows);

//    void injectDetailActivity(DetailActivity detailActivity);
}
