package com.example.matcheat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.matcheat.R;
import com.example.matcheat.model.RecommendationItem;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {

    private final List<RecommendationItem> itemList;
    private final Context context;

    // Constructor
    public MyRecyclerAdapter(Context context, List<RecommendationItem> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new MyViewHolder(view);
    }

    // Bind data to the views
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        RecommendationItem currentItem = itemList.get(position);
        holder.title.setText(currentItem.name);
        holder.rating.setText(String.valueOf(currentItem.rating));
        holder.location.setText(currentItem.region);
    }

    // Return the size of the dataset
    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Provide a reference to the views for each data item
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, rating, location;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            rating = itemView.findViewById(R.id.rating);
            location = itemView.findViewById(R.id.location);
        }
    }
}
