package com.thinkabstract.exercise.news.api.gateway;

import com.thinkabstract.exercise.news.api.service.NewsFeedService;
import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.model.QueryResult;
import com.thinkabstract.exercise.news.domain.services.remote.RemoteNewsFeedGateway;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

public class RemoteNewsFeedGatewayImp implements RemoteNewsFeedGateway {

  private NewsFeedService service;

  @Inject public RemoteNewsFeedGatewayImp(NewsFeedService service) {
    this.service = service;
  }

  @Override public Observable<List<QueryResult>> queryFeeds(String query) {
    try {
      return Observable.just(service.queryFeeds(query).execute().body().map());
    } catch (IOException e) {
      return Observable.error(e);
    }
  }

  @Override public Observable<Feed> loadFeed(String feedUrl) {
    try {
      return Observable.just(service.loadFeed(feedUrl).execute().body().map());
    } catch (IOException e) {
      return Observable.error(e);
    }
  }
}
