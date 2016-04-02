package com.thinkabstract.exercise.news.domain.services;

import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.model.QueryResult;
import java.util.List;
import rx.Observable;

public interface RemoteNewsFeedGateway {

  Observable<List<QueryResult>> queryFeeds(String query);

  Observable<Feed> loadFeed(String feedUrl);
}
