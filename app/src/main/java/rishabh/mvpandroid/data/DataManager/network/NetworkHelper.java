package rishabh.mvpandroid.data.DataManager.network;

import io.reactivex.Observable;
import rishabh.mvpandroid.data.Model.TvModelResult;
import rishabh.mvpandroid.data.Model.TvShowDetail;
import retrofit2.Response;
import rishabh.mvpandroid.data.Model.WeatherModel;

/**
 * 26/5/17.
 */

public interface NetworkHelper {

     Observable<Response<WeatherModel>> getWeatherToday(String lat, String lon);

    // Observable<Response<TvModelResult>> getTvTopRatedList(String pageNo);
    //
    //Observable<Response<TvShowDetail>> getTvShowDetails(int movie_id);
}
