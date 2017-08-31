package rishabh.mvpandroid.data.DataManager.network;

import java.util.Map;

import io.reactivex.Observable;
import rishabh.mvpandroid.data.Model.TvModelResult;
import rishabh.mvpandroid.data.Model.TvShowDetail;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * 25/5/17.
 */

public interface TvDbService {

    @GET("tv/popular")
    Observable<Response<TvModelResult>> getpopular(@QueryMap Map<String, String> queries);

    @GET("tv/top_rated")
    Observable<Response<TvModelResult>> getTopRated(@QueryMap Map<String, String> queries);

    @GET("tv/{tv_id}")
    Observable<Response<TvShowDetail>> getShowData(@Path("tv_id") int tv_id, @QueryMap Map<String, String> queries);


}
