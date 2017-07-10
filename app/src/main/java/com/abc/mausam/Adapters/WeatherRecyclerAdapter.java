package com.abc.mausam.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.abc.mausam.Models.Weather;
import com.abc.mausam.R;

import java.util.ArrayList;

/**
 * Created by Nikhil Arora on 10-07-2017.
 */

public class WeatherRecyclerAdapter extends RecyclerView.Adapter<WeatherRecyclerAdapter.ConsolidatedWeatherViewHolder> {

    Context context;
    ArrayList<Weather> weatherArrayList;


    public WeatherRecyclerAdapter(Context context, ArrayList<Weather> weatherArrayList) {
        this.context = context;
        this.weatherArrayList = weatherArrayList;
    }


    public void updateWeather (ArrayList<Weather> weatherArrayList) {
        this.weatherArrayList = weatherArrayList;
        notifyDataSetChanged();
    }


    @Override
    public ConsolidatedWeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.weather_layout , parent , false);
        return new ConsolidatedWeatherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ConsolidatedWeatherViewHolder holder, int position) {

        Weather thisweather = weatherArrayList.get(position);
        holder.applicable_date.setText((CharSequence) thisweather.getApplicable_date());
        holder.weather_state_name.setText(thisweather.getWeather_state_name());
        holder.weather_state_abbr.setText(thisweather.getWeather_state_abbr());
        holder.wind_speed.setText((int)thisweather.getWind_speed());
        holder.wind_direction.setText((int) thisweather.getWind_direction());
        holder.wind_direction_compass.setText(thisweather.getWind_direction_compass());
        holder.min_temp.setText((int) thisweather.getMin_temp());
        holder.max_temp.setText((int) thisweather.getMax_temp());
        holder.the_temp.setText((int) thisweather.getThe_temp());
        holder.air_pressure.setText((int) thisweather.getAir_pressure());
        holder.humidity.setText((int) thisweather.getHumidity());
        holder.visibility.setText((int) thisweather.getVisibility());
        holder.predictability.setText(thisweather.getPredictability());

    }

    @Override
    public int getItemCount() {
        return weatherArrayList.size();
    }

    static class ConsolidatedWeatherViewHolder extends RecyclerView.ViewHolder{

        ImageView photo;
        TextView date , applicable_date , weatherstatename , weather_state_name ,weatherstateabbr , weather_state_abbr;
        TextView windspeed , wind_speed , winddirection , wind_direction , winddirectioncompass , wind_direction_compass;
        TextView minimumtemp , min_temp , maximumtemp , max_temp , thetemp , the_temp , airpressure , air_pressure;
        TextView humidity , Humidity , Visibility , visibility , predictability , Predictability;

        public ConsolidatedWeatherViewHolder(View itemView) {
            super(itemView);

            photo = (ImageView)itemView.findViewById(R.id.photo);
            date = (TextView)itemView.findViewById(R.id.date);
            applicable_date  = (TextView)itemView.findViewById(R.id.applicable_date);
            weatherstatename = (TextView)itemView.findViewById(R.id.weatherstatename);
            weather_state_name = (TextView)itemView.findViewById(R.id.weather_state_name);
            weatherstateabbr = (TextView)itemView.findViewById(R.id.weatherstateabbr);
            weather_state_abbr = (TextView)itemView.findViewById(R.id.weather_state_abbr);
            windspeed = (TextView)itemView.findViewById(R.id.windspeed);
            wind_speed = (TextView)itemView.findViewById(R.id.wind_speed);
            winddirection = (TextView)itemView.findViewById(R.id.winddirection);
            wind_direction = (TextView)itemView.findViewById(R.id.wind_direction);
            winddirectioncompass = (TextView)itemView.findViewById(R.id.winddirectioncompass);
            wind_direction_compass = (TextView)itemView.findViewById(R.id.wind_direction_compass);
            minimumtemp = (TextView)itemView.findViewById(R.id.minimumtemp);
            min_temp = (TextView)itemView.findViewById(R.id.min_temp);
            maximumtemp = (TextView)itemView.findViewById(R.id.maximumtemp);
            max_temp = (TextView)itemView.findViewById(R.id.max_temp);
            thetemp = (TextView)itemView.findViewById(R.id.thetemp);
            the_temp = (TextView)itemView.findViewById(R.id.the_temp);
            airpressure = (TextView)itemView.findViewById(R.id.airpressure);
            air_pressure = (TextView)itemView.findViewById(R.id.air_pressure);
            humidity = (TextView)itemView.findViewById(R.id.humidity);
            Humidity = (TextView)itemView.findViewById(R.id.Humidity);
            Visibility = (TextView)itemView.findViewById(R.id.Visibility);
            visibility = (TextView)itemView.findViewById(R.id.visibility);
            predictability = (TextView)itemView.findViewById(R.id.predictability);
            Predictability = (TextView)itemView.findViewById(R.id.Predictability);

        }
    }
}
