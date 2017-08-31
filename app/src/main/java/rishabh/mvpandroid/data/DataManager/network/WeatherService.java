package rishabh.mvpandroid.data.DataManager.network;

import io.reactivex.Observable;
import java.util.Map;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rishabh.mvpandroid.data.Model.WeatherModel;

/**
 * 25/5/17.
 */

public interface WeatherService {

    @GET("/data/2.5/weather")
    Observable<Response<WeatherModel>> getWeather(@QueryMap Map<String, String> queries);



}
