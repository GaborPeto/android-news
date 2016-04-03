package com.thinkabstract.exercise.news.apismoketest.gateway;

import com.thinkabstract.exercise.news.api.gateway.RemoteNewsFeedGatewayImp;
import com.thinkabstract.exercise.news.api.service.NewsFeedServiceFactory;
import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.model.QueryResult;
import com.thinkabstract.exercise.news.domain.services.RemoteNewsFeedGateway;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import rx.observers.TestSubscriber;

public class RemoteNewsFeedGatewaySmokeTest {

  private static final String QUERY = "London";
  private static final String FEED_URL = "http://feeds.visitlondon.com/WhatsOnInLondon";

  private RemoteNewsFeedGateway gateway;

  @Before public void setUp() throws Exception {
    gateway = new RemoteNewsFeedGatewayImp(NewsFeedServiceFactory.createService());
  }

  @Test public void testQueryFeeds() throws Exception {
    TestSubscriber<List<QueryResult>> subscriber = new TestSubscriber<>();

    gateway.queryFeeds(QUERY).subscribe(subscriber);

    subscriber.assertNoErrors();
    subscriber.assertCompleted();
    subscriber.assertValueCount(1);
  }

  @Test public void testLoadFeed() throws Exception {
    TestSubscriber<Feed> subscriber = new TestSubscriber<>();

    gateway.loadFeed(FEED_URL).subscribe(subscriber);

    subscriber.assertNoErrors();
    subscriber.assertCompleted();
    subscriber.assertValueCount(1);
  }
}