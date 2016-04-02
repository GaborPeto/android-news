package com.thinkabstract.exercise.news.api.service;

import com.thinkabstract.exercise.news.api.model.ApiFeed;
import com.thinkabstract.exercise.news.api.model.ApiQueryResult;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsFeedService {

  @GET("find") Call<List<ApiQueryResult>> queryFeeds(@Query("q") String query);

  @GET("load") Call<ApiFeed> loadFeed(@Query("q") String feedURl);
}
