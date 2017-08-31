package rishabh.mvpandroid.di.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import rishabh.mvpandroid.MvpAndroid;
import rishabh.mvpandroid.Utils.Constants;
import rishabh.mvpandroid.data.DataManager.AppDataManager;
import rishabh.mvpandroid.data.DataManager.DataManager;
import rishabh.mvpandroid.data.DataManager.Preference.AppPreferenceManager;
import rishabh.mvpandroid.data.DataManager.Preference.PreferenceHelper;
import rishabh.mvpandroid.data.DataManager.network.AppNetworkManager;
import rishabh.mvpandroid.data.DataManager.network.NetworkHelper;
import rishabh.mvpandroid.di.qualifiers.ApplicationContext;
import rishabh.mvpandroid.di.qualifiers.PrefFile;
import rishabh.mvpandroid.di.scopes.ApplicationScope;

/**
 * 19/5/17.
 */

@Module
public class ApplicationModule {

    private MvpAndroid app;

    public ApplicationModule(MvpAndroid app) {
        this.app = app;
    }

    @ApplicationContext
    @Provides
    Context provideContext() {
        return app;
    }

    @PrefFile
    @Provides
    String providePrefFile() {
        return Constants.PREF_FILENAME;
    }

    @ApplicationScope
    @Provides
    DataManager provideDataManger(AppDataManager appDataManager) {
        return appDataManager;
    }

    @ApplicationScope
    @Provides
    PreferenceHelper providePreferenceHelper(AppPreferenceManager appPreferenceManager) {
        return appPreferenceManager;
    }

    @ApplicationScope
    @Provides
    NetworkHelper provideNetworkHelper(AppNetworkManager networkManager) {
        return networkManager;
    }
}
