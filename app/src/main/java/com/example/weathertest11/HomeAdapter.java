package com.example.weathertest11;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Timer;

/**
 * Created by Jason.fang on 2016/4/20.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>{
    Context context;
    List<HourlyWeather> hourlyWeathers;
    public HomeAdapter(Context context,List<HourlyWeather> hourlyWeathers) {
        super();
        this.context = context;
        this.hourlyWeathers = hourlyWeathers;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.time.setText(hourlyWeathers.get(position).time);
        holder.temperature.setText(hourlyWeathers.get(position).temp+"°");
        Picasso.with(context)
                .load("http://files.heweather.com/cond_icon/" + hourlyWeathers.get(position).id + ".png")
                .into(holder.weather_logo);
    }

    @Override
    public int getItemCount() {
        return hourlyWeathers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView time;
        ImageView weather_logo;
        TextView temperature;

        public MyViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.time);
            weather_logo = (ImageView) itemView.findViewById(R.id.weather_logo);
            temperature= (TextView) itemView.findViewById(R.id.temperature);
        }
    }
}
