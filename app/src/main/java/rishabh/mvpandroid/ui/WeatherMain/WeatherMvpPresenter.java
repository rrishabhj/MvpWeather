package rishabh.mvpandroid.ui.WeatherMain;

import rishabh.mvpandroid.ui.Base.BaseMvpPresenter;

/**
 * 26/5/17.
 */

public interface WeatherMvpPresenter<V extends WeatherMvpView> extends BaseMvpPresenter<V>{

    void loadWeatherData();

    String setWeatherIcon(int id, long sunrise, long sunset);
}
