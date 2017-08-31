package rishabh.mvpandroid.data.DataManager.network;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import rishabh.mvpandroid.Utils.Constants;
import rishabh.mvpandroid.data.Model.TvModelResult;
import rishabh.mvpandroid.data.Model.TvShowDetail;
import rishabh.mvpandroid.data.Model.WeatherModel;
import rishabh.mvpandroid.di.scopes.ApplicationScope;
import retrofit2.Response;

/**
 * 26/5/17.
 */

@ApplicationScope
public class AppNetworkManager implements NetworkHelper {

    WeatherService weatherService;

    @Inject
    public AppNetworkManager(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Override public Observable<Response<WeatherModel>> getWeatherToday(String lat, String lon) {
        Map<String, String> param = new HashMap<>();
        param.put("APPID", Constants.API_KEY);
        param.put("lat", lat);
        param.put("lon", lon);
        param.put("units", "metric");

        return weatherService.getWeather(param);
    }
}
