package rishabh.mvpandroid.ui.SignUp;

import android.os.Handler;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import java.util.Date;
import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.Response;
import rishabh.moviebuzz.R;
import rishabh.mvpandroid.Utils.CommonUtils;
import rishabh.mvpandroid.data.DataManager.DataManager;
import rishabh.mvpandroid.data.Model.TvModelResult;
import rishabh.mvpandroid.data.Model.WeatherModel;
import rishabh.mvpandroid.ui.Base.BasePresenter;

/**
 * 26/5/17.
 */

public class SignUpPresenter<V extends SignUpMvpView> extends BasePresenter<V> implements SignUpMvpPresenter<V> {

    private boolean bottomProgress= false;

    @Inject
    public SignUpPresenter(DataManager dataManager, CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override public void loadWeatherData() {


        if (!getMvpView().isNetworkAvailable()) {
            getMvpView().showError(R.string.error_message_internet_unavailable);
            return;
        }

        bottomProgress = true;

        getMvpView().showLoading(bottomProgress);

        Disposable disposable = getDataManager().getWeatherToday("28.548611","77.328853")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(new DisposableObserver<Response<WeatherModel>>() {
                @Override
                public void onNext(@NonNull Response<WeatherModel> weatherResponse) {

                    switch (weatherResponse.code()){

                        case 200:
                            getMvpView().setupViews(weatherResponse.body());
                            getMvpView().hideLoading(bottomProgress);
                            break;

                        case 401:
                            getMvpView().showError(R.string.missing_key);
                            getMvpView().hideLoading(bottomProgress);
                            break;
                    }
                }

                @Override
                public void onError(@NonNull Throwable e) {

                    getMvpView().showError(R.string.something_wrong);
                    getMvpView().hideLoading(bottomProgress);
                }

                @Override
                public void onComplete() {

                }
            });

        getCompositeDisposable().add(disposable);
    }

  @Override
  public  String setWeatherIcon(int actualId, long sunrise, long sunset){
    int id = actualId / 100;
    String icon = "";
    if(actualId == 800){
      long currentTime = new Date().getTime();
      if(currentTime>=sunrise && currentTime<sunset) {
        icon = "&#xf00d;";
      } else {
        icon = "&#xf02e;";
      }
    } else {
      switch(id) {
        case 2 : icon = "&#xf01e;";
          break;
        case 3 : icon = "&#xf01c;";
          break;
        case 7 : icon = "&#xf014;";
          break;
        case 8 : icon = "&#xf013;";
          break;
        case 6 : icon = "&#xf01b;";
          break;
        case 5 : icon = "&#xf019;";
          break;
      }
    }
    return icon;
  }

}
