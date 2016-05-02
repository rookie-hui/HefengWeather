package com.example.weathertest11;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jason.fang on 2016/4/21.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MyViewHolder>{
    private Context context;
    private List<CityName> cityNames;
    public CityAdapter(Context context,List<CityName> cityNames) {
        super();
        this.context = context;
        this.cityNames = cityNames;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_city,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(cityNames.get(position));
    }

    @Override
    public int getItemCount() {
        return cityNames.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView id_city;
        CityName cityName;
        public MyViewHolder(View itemView) {
            super(itemView);
            id_city = (TextView) itemView.findViewById(R.id.id_city);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            CityActivity ac = (CityActivity) v.getContext();
            ac.setResult(Activity.RESULT_OK, new Intent().putExtra(CityActivity.RESP_EXTRA_CITY_ID, cityName.id)
                                                    .putExtra(CityActivity.RESP_EXTRA_CITY_NAME,cityName.name));
            ac.finish();
        }

        public void bind(CityName cityName) {
            this.cityName = cityName;
            id_city.setText(cityName.name);
        }
    }
}
