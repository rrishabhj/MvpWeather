package rishabh.mvpandroid.di.modules;

import dagger.Module;
import dagger.Provides;
import rishabh.mvpandroid.Utils.Constants;
import rishabh.mvpandroid.data.DataManager.network.WeatherService;
import rishabh.mvpandroid.di.qualifiers.Url;
import rishabh.mvpandroid.di.scopes.ApplicationScope;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 19/5/17.
 */

@Module
public class NetworkModule {

    @ApplicationScope
    @Provides
    Retrofit provideRetrofit(@Url String baseUrl) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Url
    @Provides
    String retrofitUrl() {
        return Constants.BASE_URL;
    }

    @ApplicationScope
    @Provides WeatherService getMovieDbService(Retrofit retrofit) {
        return  retrofit.create(WeatherService.class);
    }
}
