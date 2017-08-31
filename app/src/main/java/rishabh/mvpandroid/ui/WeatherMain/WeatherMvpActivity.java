package rishabh.mvpandroid.ui.WeatherMain;


import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rishabh.moviebuzz.R;
import rishabh.mvpandroid.data.Model.WeatherModel;
import rishabh.mvpandroid.ui.About;
import rishabh.mvpandroid.ui.Base.BaseActivity;

/**
 * 26/5/17.
 */

public class WeatherMvpActivity extends BaseActivity implements WeatherMvpView {

    @Inject
    WeatherMvpPresenter<WeatherMvpView> loginMvpPresenter;

    @BindView(R.id.city_field)
    TextView cityField;

    @BindView(R.id.updated_field)
    TextView updatedFeld;

    @BindView(R.id.weather_icon)
    TextView weatherIcon;

    @BindView(R.id.current_temperature_field)
    TextView currentTemperatureField;

    @BindView(R.id.details_field)
    TextView detailsField;

    @BindView(R.id.humidity_field)
    TextView humidityField;

    @BindView(R.id.pressure_field)
    TextView pressureField;

    @BindView(R.id.progress_Bar)
    ProgressBar progressBar;
    private Typeface weatherFont;

    @BindView(R.id.about_icon)
    ImageView aboutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        getActivityComponent().injectLoginActivity(this);
        ButterKnife.bind(this);
        loginMvpPresenter.onAttach(this);
        setUpActivity();
        loginMvpPresenter.loadWeatherData();

    }

    @OnClick(R.id.about_icon)
    public void OpenAboutActivity(View view){

        startActivity(new Intent(WeatherMvpActivity.this, About.class));

    }

    @Override public void setUpActivity() {
        weatherFont = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");
        weatherIcon.setTypeface(weatherFont);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginMvpPresenter.onDetach();
    }


    @Override
    public void showLoading(boolean bottomProgress) {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading(boolean bottomProgress) {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override public void setupViews(WeatherModel weatherModel) {
        DateFormat df = DateFormat.getDateTimeInstance();

        cityField.setText(weatherModel.getName());
        updatedFeld.setText(df.format(new Date(weatherModel.getDt()*1000)));
        detailsField.setText(weatherModel.getWeather().get(1).getDescription().toUpperCase(Locale.US) );
        currentTemperatureField.setText(weatherModel.getMain().getTemp()+" C");
        humidityField.setText("Humidity: " + weatherModel.getMain().getHumidity()+"%");
        pressureField.setText("Pressure: " + weatherModel.getMain().getPressure()+"hpa");
        weatherIcon.setText(Html.fromHtml(loginMvpPresenter.setWeatherIcon(weatherModel.getWeather().get(1).getId(),
            weatherModel.getSys().getSunrise() * 1000,
            weatherModel.getSys().getSunset() * 1000)));
    }
}
