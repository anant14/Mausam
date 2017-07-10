package com.abc.mausam.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.abc.mausam.Models.LocationSearch;
import com.abc.mausam.R;
import com.abc.mausam.WeatherStatus;

import java.util.ArrayList;

/**
 * Created by Nikhil Arora on 08-07-2017.
 */

public class PlaceRecyclerAdapter extends RecyclerView.Adapter<PlaceRecyclerAdapter.PlaceViewHolder> {

    Context context;
    ArrayList<LocationSearch> locationSearchArrayList;

    public PlaceRecyclerAdapter(Context context, ArrayList<LocationSearch> locationSearchArrayList) {
        this.context = context;
        this.locationSearchArrayList = locationSearchArrayList;
    }

    public void updateLocation(ArrayList<LocationSearch> newLocationList) {
        this.locationSearchArrayList = newLocationList;
        notifyDataSetChanged();
    }

    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li  = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.location_layout , parent , false);
        return new PlaceViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {

        final LocationSearch thislocation = locationSearchArrayList.get(position);

        holder.title.setText(thislocation.getTitle());
        holder.location_type.setText(thislocation.getLocation_type());
        holder.rootview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context , WeatherStatus.class);
                int woeid = thislocation.getWoeid();
                i.putExtra("woeid",woeid);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount()
    {
        return locationSearchArrayList.size();
    }

    static class PlaceViewHolder extends RecyclerView.ViewHolder{

        TextView title , location_type;
        View rootview;
        public PlaceViewHolder(View itemView) {
            super(itemView);

            rootview = itemView;
            title = (TextView)itemView.findViewById(R.id.title);
            location_type = (TextView)itemView.findViewById(R.id.location_type);
        }
    }
}
