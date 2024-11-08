package com.example.matcheat.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit2Client {

  private static Retrofit2Client instance = null;
  private final ApiService exploreService;

  public Retrofit2Client() {

   /* HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    okHttpBuilder.addInterceptor(new TokenInterceptor());

    if (BuildConfig.DEBUG) {
      okHttpBuilder.addInterceptor(loggingInterceptor);
    }
*/
    OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
      OkHttpClient client = okHttpBuilder.build();

      Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.API_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .client(client)
              .build();

    exploreService = retrofit.create(ApiService.class);
  }

  public static Retrofit2Client getInstance() {
    if (instance == null) {
      instance = new Retrofit2Client();
    }

    return instance;
  }

  public ApiService getApiService() {
    return exploreService;
  }
}