package com.example.weathertest11;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jason.fang on 2016/4/21.
 */
public class CityInfoBean {

    @SerializedName("city")
    public String city;
    @SerializedName("id")
    public String id;

    @Override
    public String toString() {
        return "CityInfoBean{" +
                "city='" + city + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
