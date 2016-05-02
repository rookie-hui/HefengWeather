package com.example.weathertest11;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Jason.fang on 2016/4/21.
 */
public class CityList {
    @SerializedName("status")
    public String status;

    @SerializedName("city_info")
    public List<CityInfoBean> cityInfo;

    @Override
    public String toString() {
        return "CityList{" +
                "status='" + status + '\'' +
                ", cityInfo=" + cityInfo +
                '}';
    }

}
