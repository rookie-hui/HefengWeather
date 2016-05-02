package com.example.weathertest11.sp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jason.fang on 2016/4/22.
 */
public class SpHelper {
    SharedPreferences sp;
    public SpHelper(Context context){
        sp = context.getSharedPreferences("weather", Context.MODE_PRIVATE);
    }
    public String getString(String key){
        return sp.getString(key, null);
    }

    public void putString(String key, String value){
        sp.edit().putString(key, value).apply();
    }
}
