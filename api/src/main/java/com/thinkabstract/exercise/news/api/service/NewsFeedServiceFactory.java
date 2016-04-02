package com.thinkabstract.exercise.news.api.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsFeedServiceFactory {

  private static final String BASE_NEWS_FEED_URL =
      "https://ajax.googleapis.com/ajax/services/feed/";

  public static NewsFeedService createService() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_NEWS_FEED_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    return retrofit.create(NewsFeedService.class);
  }
}
