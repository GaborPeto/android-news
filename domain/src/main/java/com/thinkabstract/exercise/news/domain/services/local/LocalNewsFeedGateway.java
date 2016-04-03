package com.thinkabstract.exercise.news.domain.services.local;

import com.thinkabstract.exercise.news.domain.model.Feed;
import java.util.List;

public interface LocalNewsFeedGateway {

  void saveFeed(Feed feed);

  List<Feed> loadFeeds();
}
