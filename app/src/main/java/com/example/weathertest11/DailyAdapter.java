package com.example.weathertest11;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jason.fang on 2016/4/20.
 */
public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.MyViewHolder> {
    private Context context;
    private List<DailyWeather> dailyWeathers;

    public DailyAdapter(Context context, List<DailyWeather> dailyWeathers){
        super();
        this.context = context;
        this.dailyWeathers = dailyWeathers;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_daily,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.date.setText(dailyWeathers.get(position).date);
        holder.min_temp_daily.setText(dailyWeathers.get(position).min_temp_daily);
        holder.max_temp_daily.setText(dailyWeathers.get(position).max_temp_daily);
        Picasso .with(context)
                .load(  "http://files.heweather.com/cond_icon/"
                        + dailyWeathers.get(position).weather_logo_daily
                        + ".png")
                .into(holder.weather_logo_daily);
    }

    @Override
    public int getItemCount() {
        return dailyWeathers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView date ;
        ImageView weather_logo_daily;
        TextView max_temp_daily;
        TextView min_temp_daily;
        public MyViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.date);
            weather_logo_daily = (ImageView) itemView.findViewById(R.id.weather_logo_daily);
            max_temp_daily = (TextView) itemView.findViewById(R.id.max_temp_daily);
            min_temp_daily = (TextView) itemView.findViewById(R.id.min_temp_daily);
        }
    }
}
