package rishabh.mvpandroid.data.DataManager.Preference;

/**
 * 26/5/17.
 */

public interface PreferenceHelper {

    void addCurrentUserEmail(String email);

    String getCurrentUserEmail();

    void deleteCredentials();
}
