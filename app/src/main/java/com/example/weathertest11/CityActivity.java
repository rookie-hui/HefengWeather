package com.example.weathertest11;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jason.fang on 2016/4/21.
 */
public class CityActivity extends AppCompatActivity {

    public static final String RESP_EXTRA_CITY_ID = "resp:extra:city:id";
    public static final String RESP_EXTRA_CITY_NAME = "resp:extra:city:name";

    WeatherService weather;
    CityList cityList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview_city);
        weather = new WeatherService();
        weather.getCity("allchina", "49647057744343069999fbf5bb78082a", new Callback<CityList>() {
            @Override
            public void onResponse(Call<CityList> call, Response<CityList> response) {
                cityList = response.body();

                LinearLayoutManager manager = new LinearLayoutManager(CityActivity.this);
                manager.setOrientation(LinearLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(manager);
                List<CityName> cityNames = new ArrayList<>();
                for(int i = 0;i<cityList.cityInfo.size();i++){
                    CityName cName = new CityName();
                    cName.name = cityList.cityInfo.get(i).city;
                    cName.id = cityList.cityInfo.get(i).id;
                    cityNames.add(cName);
                }
                CityAdapter adapter = new CityAdapter(CityActivity.this,cityNames);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<CityList> call, Throwable t) {

            }
        });
    }
}
