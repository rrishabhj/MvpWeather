package rishabh.mvpandroid.di.components;

import dagger.Component;
import rishabh.mvpandroid.MvpAndroid;
import rishabh.mvpandroid.data.DataManager.DataManager;
import rishabh.mvpandroid.di.modules.ApplicationModule;
import rishabh.mvpandroid.di.modules.NetworkModule;
import rishabh.mvpandroid.di.scopes.ApplicationScope;

/**
 * 19/5/17.
 */

@ApplicationScope
@Component(modules = {ApplicationModule.class , NetworkModule.class})
public interface ApplicationComponent {

    void inject(MvpAndroid app);

    DataManager getDataManager();

}

