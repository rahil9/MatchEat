package com.example.matcheat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.matcheat.R;
import com.example.matcheat.model.RecommendationItem;

import java.util.List;

public class MyListViewAdapter extends BaseAdapter {

    private List<RecommendationItem> itemList;
    private Context context;
    private LayoutInflater inflater;

    // Constructor
    public MyListViewAdapter(Context context, List<RecommendationItem> list) {
        this.context = context;
        this.itemList = list;
        this.inflater = LayoutInflater.from(context);
    }

    // Return the size of the dataset
    @Override
    public int getCount() {
        return itemList.size();
    }

    // Return an item at a specific position
    @Override
    public RecommendationItem getItem(int position) {
        return itemList.get(position);
    }

    // Return the row ID of an item at a specific position
    @Override
    public long getItemId(int position) {
        return position;
    }

    // Create a new view for each item referenced by the adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // Reuse views if possible for efficient scrolling
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_layout, parent, false);
            holder = new ViewHolder();
            holder.title = convertView.findViewById(R.id.title);
            holder.rating = convertView.findViewById(R.id.rating);
            holder.location = convertView.findViewById(R.id.location);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Bind data to views
        RecommendationItem currentItem = itemList.get(position);
        holder.title.setText(currentItem.name);
        holder.rating.setText(String.valueOf(currentItem.rating));
        holder.location.setText(currentItem.region);

        return convertView;
    }

    // ViewHolder pattern to improve performance
    private static class ViewHolder {
        TextView title;
        TextView rating;
        TextView location;
    }
}
