package com.thinkabstract.exercise.news.api.service;

import com.thinkabstract.exercise.news.api.model.feed.RemoteFeedResponse;
import com.thinkabstract.exercise.news.api.model.query.RemoteQueryResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsFeedService {

  String FEED_API_VERSION = "1.0";
  String FEED_API_VERSION_PARAM = "?v=" + FEED_API_VERSION;

  @GET("find" + FEED_API_VERSION_PARAM) Call<RemoteQueryResponse> queryFeeds(
      @Query("q") String query);

  @GET("load" + FEED_API_VERSION_PARAM) Call<RemoteFeedResponse> loadFeed(@Query("q") String feedURl);
}
