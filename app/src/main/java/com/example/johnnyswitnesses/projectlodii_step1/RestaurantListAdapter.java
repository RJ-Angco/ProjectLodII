package com.example.johnnyswitnesses.projectlodii_step1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RestaurantListAdapter extends RecyclerView.Adapter<RestaurantListAdapter.ViewHolder> {
    public ArrayList<RestaurantBean> restaurants;
    public RestaurantListAdapter(ArrayList<RestaurantBean> restList){
        this.restaurants = restList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_restaurant, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RestaurantListAdapter.ViewHolder holder, int position) {
        holder.nameText.setText(restaurants.get(position).getName());
        holder.descText.setText(restaurants.get(position).getDescription());
        String strMinPrice = String.valueOf(restaurants.get(position).getMinPrice());
        String strMaxPrice = String.valueOf(restaurants.get(position).getMaxPrice());
        holder.minpriceText.setText(strMinPrice);
        holder.maxPriceText.setText(strMaxPrice);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public TextView nameText;
        public TextView descText;
        public TextView minpriceText;
        public TextView maxPriceText;
        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            nameText = (TextView) mView.findViewById(R.id.name_text);
            descText = (TextView) mView.findViewById(R.id.desc_text);
            minpriceText = (TextView) mView.findViewById(R.id.minprice_text);
            maxPriceText = (TextView) mView.findViewById(R.id.maxprice_text);
        }
    }
}
