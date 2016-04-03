package com.thinkabstract.exercise.news.api.model.feed;

import com.google.gson.annotations.SerializedName;
import com.thinkabstract.exercise.news.domain.model.Feed;

public class RemoteFeedResponseData {

  @SerializedName("feed") RemoteFeed feed;

  public Feed map() {
    return feed.map();
  }
}
