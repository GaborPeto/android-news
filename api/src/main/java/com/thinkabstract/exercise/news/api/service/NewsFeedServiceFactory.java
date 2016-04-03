package com.thinkabstract.exercise.news.api.service;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsFeedServiceFactory {

  private static final String BASE_NEWS_FEED_URL =
      "https://ajax.googleapis.com/ajax/services/feed/";

  public static NewsFeedService createService() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_NEWS_FEED_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(buildClient())
        .build();

    return retrofit.create(NewsFeedService.class);
  }

  private static OkHttpClient buildClient() {
    return new OkHttpClient.Builder().addInterceptor(buildHttpLoggingInterceptor()).build();
  }

  private static HttpLoggingInterceptor buildHttpLoggingInterceptor() {
    HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
    interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return interceptor;
  }
}
