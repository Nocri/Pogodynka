package sample;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sample.model.ForecastDay;
import sample.model.MainResponse;
import sample.wrapper.ServiceWrapper;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

public class Controller implements Initializable {
    public ImageView imageView1, imageView2, imageView3, imageView4, imageView5;
    public Label dayLabel1, dayLabel2, dayLabel3, dayLabel4, dayLabel5;
    public Label tempLabel1, tempLabel2, tempLabel3, tempLabel4, tempLabel5;
    public ChoiceBox cityChoiceBox;
    public Button addButton;
    public Label todayLabel;

    private List<String> cities = Arrays.asList("Warszawa", "Gdynia", "Zgierz", "Gdansk");
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd EEEE", Locale.getDefault());
    private SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("EEEE dd.MM", Locale.getDefault());

    public void initialize(URL location, ResourceBundle resources) {
        initChoiceBox();
        showTodayDate();
        refreshWeather();
        setOnClicks();
    }

    private void initChoiceBox() {
        cityChoiceBox.getItems().addAll(cities);
        cityChoiceBox.setValue(cities.get(0));
        cityChoiceBox.setOnAction(event -> ServiceWrapper.getWeather((String) cityChoiceBox.getValue(), responseCallback));
    }

    private void showTodayDate() {
        todayLabel.setText(simpleDateFormat2.format(new Date()));
        changeViewsVisibility(true);
    }

    private void showError() {
        todayLabel.setText("Błąd serwera");
        changeViewsVisibility(false);
    }

    private void refreshWeather() {
        ServiceWrapper.getWeather((String) cityChoiceBox.getValue(), responseCallback);
    }

    private void setOnClicks() {
        addButton.setOnAction(event -> {
                    String newCity = ConfirmBox.display("Dodaj miasto", "Nazwa miasta:");
                    if (!newCity.isEmpty()) {
                        cityChoiceBox.getItems().add(newCity);
                        cityChoiceBox.setValue(newCity);
                        refreshWeather();
                    }
                }
        );
    }

    private void fillViews(Response<MainResponse> response) {
        if (response == null || response.body() == null
                || response.body().forecast == null) {
            showError();
            return;
        }
        List<ForecastDay> forecastDaysList = response.body().forecast.simpleforecast.forecastday;
        fillSingleBlock(forecastDaysList.get(0), imageView1, dayLabel1, tempLabel1);
        fillSingleBlock(forecastDaysList.get(1), imageView2, dayLabel2, tempLabel2);
        fillSingleBlock(forecastDaysList.get(2), imageView3, dayLabel3, tempLabel3);
        fillSingleBlock(forecastDaysList.get(3), imageView4, dayLabel4, tempLabel4);
        fillSingleBlock(forecastDaysList.get(4), imageView5, dayLabel5, tempLabel5);
        showTodayDate();
    }

    private void fillSingleBlock(ForecastDay forecastDay, ImageView imageView, Label dayLabel, Label tempLabel) {
        imageView.setImage(new Image(forecastDay.icon_url));
        dayLabel.setText(simpleDateFormat.format(new Date(forecastDay.date.epoch * 1000L)));
        tempLabel.setText(forecastDay.high.celsius + "C");
    }

    private void changeViewsVisibility(boolean shouldShow) {
        imageView1.setVisible(shouldShow);
        imageView2.setVisible(shouldShow);
        imageView3.setVisible(shouldShow);
        imageView4.setVisible(shouldShow);
        imageView5.setVisible(shouldShow);
        dayLabel1.setVisible(shouldShow);
        dayLabel2.setVisible(shouldShow);
        dayLabel3.setVisible(shouldShow);
        dayLabel4.setVisible(shouldShow);
        dayLabel5.setVisible(shouldShow);
        tempLabel1.setVisible(shouldShow);
        tempLabel2.setVisible(shouldShow);
        tempLabel3.setVisible(shouldShow);
        tempLabel4.setVisible(shouldShow);
        tempLabel5.setVisible(shouldShow);
    }

    private Callback<MainResponse> responseCallback = new Callback<MainResponse>() {
        @Override
        public void onResponse(Call<MainResponse> call, Response<MainResponse> response) {
            Platform.runLater(() -> fillViews(response));
        }

        @Override
        public void onFailure(Call<MainResponse> call, Throwable throwable) {
            throwable.printStackTrace();
            showError();
        }
    };
}
