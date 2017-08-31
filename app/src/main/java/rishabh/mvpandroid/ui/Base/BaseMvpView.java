package rishabh.mvpandroid.ui.Base;

/**
 * 13/5/17.
 */

import android.support.annotation.StringRes;

/**
 * Base interface that any class that wants to act as a View in the MVP (Model View Presenter)
 * pattern must implement. Generally this interface will be extended by a more specific interface
 * that then usually will be implemented by an Activity or Fragment.
 */
public interface BaseMvpView {

    void showError(@StringRes int error_message);

    void showLoading(boolean bottomProgress);

    void hideLoading(boolean bottomProgress);

    boolean isNetworkAvailable();

}
