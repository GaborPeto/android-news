package com.thinkabstract.exercise.news.api.model.feed;

import com.thinkabstract.exercise.news.api.model.RemoteResponse;
import com.thinkabstract.exercise.news.domain.model.Feed;

public class RemoteFeedResponse extends RemoteResponse<RemoteFeedResponseData> {

  public Feed map() {
    return responseData.map();
  }
}
