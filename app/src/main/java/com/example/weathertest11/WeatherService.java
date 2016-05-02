package com.example.weathertest11;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Jason.fang on 2016/4/19.
 */
public class WeatherService {
    public static final String URL_API = "http://api.heweather.com/";
    private Weather weather;

    public WeatherService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        weather = retrofit.create(Weather.class);
    }

    interface Weather {
        @GET("x3/weather")
        Call<WeatherBean> getWeather(@Query("cityid") String cityid, @Query("key") String key);

        @GET("x3/citylist")
        Call<CityList> getCity(@Query("search") String search, @Query("key") String key);
    }

    public void getCity(String search, String key, Callback<CityList> callback) {
        weather.getCity(search, key).enqueue(callback);
    }

    public void getWeather(String cityid, String key, Callback<WeatherBean> callback) {
        weather.getWeather(cityid, key).enqueue(callback);
    }
}
