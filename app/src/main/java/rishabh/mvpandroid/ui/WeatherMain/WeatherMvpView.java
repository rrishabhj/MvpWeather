package rishabh.mvpandroid.ui.WeatherMain;

import rishabh.mvpandroid.data.Model.WeatherModel;
import rishabh.mvpandroid.ui.Base.BaseMvpView;

/**
 * 26/5/17.
 */

public interface WeatherMvpView extends BaseMvpView {


    void setupViews(WeatherModel weatherModel);

}
