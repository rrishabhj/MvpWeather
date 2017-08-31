package rishabh.mvpandroid.data.DataManager.Preference;


import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import rishabh.mvpandroid.Utils.Constants;
import rishabh.mvpandroid.di.qualifiers.ApplicationContext;
import rishabh.mvpandroid.di.qualifiers.PrefFile;
import rishabh.mvpandroid.di.scopes.ApplicationScope;

/**
 * 26/5/17.
 */

@ApplicationScope
public class AppPreferenceManager implements PreferenceHelper {

    private SharedPreferences mPrefs;

    @Inject
    public AppPreferenceManager(@ApplicationContext Context context, @PrefFile String prefName) {
        mPrefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Override
    public void addCurrentUserEmail(final String email) {
        mPrefs.edit().putString(Constants.PREF_USER_EMAIL, email).apply();
    }

    @Override
    public String getCurrentUserEmail() {
        return mPrefs.getString(Constants.PREF_USER_EMAIL, null);
    }

    @Override
    public void deleteCredentials() {
        mPrefs.edit().clear().apply();
    }


}
