package sample.wrapper;

import sample.model.MainResponse;

/**
 * Created by Mikołaj Karwowski on 17.02.2018.
 */

public class ServiceWrapper {
    private static RetrofitInterface client = ServiceGenerator.createService(RetrofitInterface.class);

    public static void getWeather(String city, retrofit2.Callback<MainResponse> callback){
        client.getWeather(city).enqueue(callback);
    }

}
