package com.thinkabstract.exercise.news.persistence.gateway;

import android.support.test.InstrumentationRegistry;
import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.model.FeedEntry;
import com.thinkabstract.exercise.news.domain.services.local.LocalNewsFeedGateway;
import com.thinkabstract.exercise.news.persistence.operation.feed.FeedOperation;
import io.realm.RealmConfiguration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocalNewsFeedGatewayImpTest {

  private LocalNewsFeedGateway gateway;

  @Before public void setUp() throws Exception {
    initGateway();
  }

  @Test public void testSaveLoadFeed() throws Exception {
    Feed feed = buildFeed();
    gateway.saveFeed(feed);

    List<Feed> feeds = gateway.loadFeeds();

    assertTrue(feeds.contains(feed));
  }

  private Feed buildFeed() {
    Feed feed = new Feed();
    feed.title = "title";
    feed.description = "description";
    feed.entries = new ArrayList<>();
    feed.entries.add(buildFeedEntry());
    return feed;
  }

  private FeedEntry buildFeedEntry() {
    FeedEntry entry = new FeedEntry();
    entry.title = "entry title";
    entry.contentSnippet = "content snippet";
    entry.content = "content";
    entry.publishedDate = new Date();
    return entry;
  }

  private void initGateway() {
    RealmConfiguration configuration = new RealmConfiguration.Builder(
        InstrumentationRegistry.getContext()).deleteRealmIfMigrationNeeded().build();
    FeedOperation operation = new FeedOperation(configuration);
    gateway = new LocalNewsFeedGatewayImp(operation);
  }
}