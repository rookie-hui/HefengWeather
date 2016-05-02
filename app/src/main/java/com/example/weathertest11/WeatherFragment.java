package com.example.weathertest11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weathertest11.sp.SpHelper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jason.fang on 2016/4/21.
 */
public class WeatherFragment extends Fragment {
    private static final int REQUEST_CHOOSE_CITY = 201;

    private static final String KEY_CITY_ID = "key_city_id";

    Context context;
    WeatherService weatherService;
    WeatherBean bean;
    RecyclerView recyclerView;
    RecyclerView recyclerView_daily;
    View view;
    SpHelper sp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        sp = new SpHelper(getContext());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.weather_fragment,container,false);
        context = view.getContext();
        return view;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String cityId = sp.getString(KEY_CITY_ID);
        if(cityId == null) cityId = "CN101020100";
        getBean(cityId);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.choose_item) {
            startActivityForResult(new Intent(getContext(), CityActivity.class), REQUEST_CHOOSE_CITY);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CHOOSE_CITY:
                if(Activity.RESULT_OK == resultCode) {
                    String cityId = data.getStringExtra(CityActivity.RESP_EXTRA_CITY_ID);
                    sp.putString(KEY_CITY_ID, cityId);
                    getBean(cityId);
                }
                break;
            default:
        }
    }

    private void getRecyclerViewDaily() {
        recyclerView_daily = (RecyclerView) view.findViewById(R.id.recyclerview_daily);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_daily.setLayoutManager(manager);
        List<DailyWeather> dailyWeathers = new ArrayList<>();
        for (int i = 1; i < bean.service.get(0).dailyForecast.size(); i++) {
            DailyWeather daily = new DailyWeather();
            daily.date = bean.service.get(0).dailyForecast.get(i).date;
            daily.weather_logo_daily = bean.service.get(0).dailyForecast.get(i).cond.codeD;
            daily.min_temp_daily = bean.service.get(0).dailyForecast.get(i).tmp.min + "°";
            daily.max_temp_daily = bean.service.get(0).dailyForecast.get(i).tmp.max + "°";
            dailyWeathers.add(daily);
        }
        DailyAdapter adapter = new DailyAdapter(context, dailyWeathers);
        recyclerView_daily.setAdapter(adapter);
    }

    private void getRecyclerView() {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        List<HourlyWeather> hourlyWeathers = new ArrayList<>();
        for (int i = 0; i < bean.service.get(0).hourlyForecast.size(); i++) {
            HourlyWeather hourly = new HourlyWeather();
            hourly.temp = bean.service.get(0).hourlyForecast.get(i).tmp;
            hourly.id = bean.service.get(0).now.cond.code;
            hourly.time = bean.service.get(0).hourlyForecast.get(i).date.substring(11);
            hourlyWeathers.add(hourly);
        }

        HomeAdapter adapter = new HomeAdapter(context, hourlyWeathers);
        recyclerView.setAdapter(adapter);
    }

    private void getBean(String cityId) {
        weatherService = new WeatherService();
        weatherService.getWeather(cityId, "49647057744343069999fbf5bb78082a", new Callback<WeatherBean>() {
            @Override
            public void onResponse(Call<WeatherBean> call, Response<WeatherBean> response) {
                bean = response.body();
                getRecyclerView();
                getRecyclerViewDaily();
                TextView city = (TextView) view.findViewById(R.id.cityName);
                city.setText(bean.service.get(0).basic.city);

                TextView temp = (TextView) view.findViewById(R.id.now_temperature);
                temp.setText(bean.service.get(0).now.tmp + "°");
                TextView date = (TextView) view.findViewById(R.id.now_date);
                date.setText(bean.service.get(0).dailyForecast.get(0).date + " 今天");
                TextView weather = (TextView) view.findViewById(R.id.weather);
                weather.setText(bean.service.get(0).now.cond.txt);
                TextView max_temp = (TextView) view.findViewById(R.id.max_temp);
                max_temp.setText(bean.service.get(0).dailyForecast.get(0).tmp.max);
                TextView min_temp = (TextView) view.findViewById(R.id.min_temp);
                min_temp.setText(bean.service.get(0).dailyForecast.get(0).tmp.min);

                TextView weather_info = (TextView) view.findViewById(R.id.weather_info);
                weather_info.setText("今天：" + bean.service.get(0).dailyForecast.get(0).cond.txtD
                        + "，最高气温" + bean.service.get(0).dailyForecast.get(0).tmp.max
                        + "° 今晚:" + bean.service.get(0).dailyForecast.get(0).cond.txtN
                        + "，最低气温" + bean.service.get(0).dailyForecast.get(0).tmp.min);

                TextView sunrise_time = (TextView) view.findViewById(R.id.sunrise_time);
                sunrise_time.setText(bean.service.get(0).dailyForecast.get(0).astro.sr);

                TextView sunset_time = (TextView) view.findViewById(R.id.sunset_time);
                sunset_time.setText(bean.service.get(0).dailyForecast.get(0).astro.ss);

                TextView wind_velocity_num = (TextView) view.findViewById(R.id.wind_velocity_num);
                wind_velocity_num.setText(bean.service.get(0).now.wind.spd + "m/秒");

                TextView apparent_temperature_num = (TextView) view.findViewById(R.id.apparent_temperature_num);
                apparent_temperature_num.setText(bean.service.get(0).now.fl + "°");
                TextView precipitation_num = (TextView) view.findViewById(R.id.precipitation_num);
                precipitation_num.setText(bean.service.get(0).dailyForecast.get(0).pcpn + "厘米");

                TextView barometric_pressure_num = (TextView) view.findViewById(R.id.barometric_pressure_num);
                barometric_pressure_num.setText(bean.service.get(0).now.pres + "百帕");

            }

            @Override
            public void onFailure(Call<WeatherBean> call, Throwable t) {

            }
        });
    }

}
