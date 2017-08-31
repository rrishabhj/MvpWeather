package rishabh.mvpandroid.ui.SignUp;

import rishabh.mvpandroid.ui.Base.BaseMvpPresenter;

/**
 * 26/5/17.
 */

public interface SignUpMvpPresenter<V extends SignUpMvpView> extends BaseMvpPresenter<V>{

    void loadWeatherData();

    String setWeatherIcon(int id, long sunrise, long sunset);
}
