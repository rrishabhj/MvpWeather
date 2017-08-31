package rishabh.mvpandroid.data.DataManager;

import android.content.Context;

import javax.inject.Inject;

import io.reactivex.Observable;
import rishabh.mvpandroid.data.DataManager.Preference.PreferenceHelper;
import rishabh.mvpandroid.data.DataManager.network.NetworkHelper;
import rishabh.mvpandroid.data.Model.WeatherModel;
import rishabh.mvpandroid.di.qualifiers.ApplicationContext;
import rishabh.mvpandroid.di.scopes.ApplicationScope;
import retrofit2.Response;

/**
 * 26/5/17.
 */

@ApplicationScope
public class AppDataManager implements DataManager {

    private PreferenceHelper mPreferenceHelper;
    private NetworkHelper mNetworkHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, NetworkHelper networkHelper,
                          PreferenceHelper preferenceHelper) {
        this.mPreferenceHelper = preferenceHelper;
        this.mNetworkHelper = networkHelper;
    }


    @Override
    public void addCurrentUserEmail(String email) {
        mPreferenceHelper.addCurrentUserEmail(email);

    }

    @Override
    public String getCurrentUserEmail() {
        return mPreferenceHelper.getCurrentUserEmail();
    }

    @Override
    public void deleteCredentials() {
        mPreferenceHelper.deleteCredentials();
    }

    @Override public Observable<Response<WeatherModel>> getWeatherToday(String lat, String lon) {
        return  mNetworkHelper.getWeatherToday(lat,lon);
    }
}
