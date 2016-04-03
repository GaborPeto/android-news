package com.thinkabstract.exercise.news.persistence.gateway;

import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.services.local.LocalNewsFeedGateway;
import com.thinkabstract.exercise.news.persistence.operation.feed.FeedOperation;
import java.util.List;
import javax.inject.Inject;

import static com.thinkabstract.exercise.news.persistence.mapper.PersistableFeedMapper.mapFeed;
import static com.thinkabstract.exercise.news.persistence.mapper.PersistableFeedMapper.mapPersistableFeedList;

public class LocalNewsFeedGatewayImp implements LocalNewsFeedGateway {

  private FeedOperation operation;

  @Inject public LocalNewsFeedGatewayImp(FeedOperation operation) {
    this.operation = operation;
  }

  @Override public void saveFeed(Feed feed) {
    operation.saveFeed(mapFeed(feed));
  }

  @Override public List<Feed> loadFeeds() {
    return mapPersistableFeedList(operation.query());
  }
}
