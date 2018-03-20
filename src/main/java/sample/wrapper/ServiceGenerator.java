package sample.wrapper;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Mikołaj Karwowski on 17.02.2018.
 */
public class ServiceGenerator {

    // TODO MK 17.02.2018 - change BASE_URL
    private static final String BASE_URL = "http://api.wunderground.com/api/f3aa30e893ddb114/forecast10day/q/";

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = builder.build();

    private static OkHttpClient.Builder httpClient =
            new OkHttpClient.Builder();

    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
