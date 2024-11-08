package com.example.matcheat.network;

import com.example.matcheat.model.Recommendation;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/recommend")
    Call<Recommendation> getRecommendation(@Query("cuisine") String cuisine,
                                           @Query("min_rating")String minRating);
}
