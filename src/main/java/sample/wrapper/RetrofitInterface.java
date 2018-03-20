package sample.wrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import sample.model.MainResponse;

/**
 * Created by Mikołaj Karwowski on 17.02.2018.
 */

public interface RetrofitInterface {
    @GET("PL/{City}.json")
    Call<MainResponse> getWeather(@Path("City") String city);
}
