package com.example.matcheat.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class RecommendationItem {
    @SerializedName("CUISINE_CATEGORY")
    public String cuisineCategory;
    @SerializedName("NAME")
    public String name;
    @SerializedName("RATING")
    public double rating;
    @SerializedName("REGION")
    public String region;

    @NonNull
    @Override
    public String toString() {
        return "RecommendationItem{" +
                "cuisineCategory='" + cuisineCategory + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", region='" + region + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return region;
    }
}

