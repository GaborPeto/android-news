package com.thinkabstract.exercise.news.persistence.gateway;

import android.support.test.InstrumentationRegistry;
import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.model.FeedEntry;
import com.thinkabstract.exercise.news.domain.services.local.LocalNewsFeedGateway;
import com.thinkabstract.exercise.news.persistence.operation.feed.FeedOperation;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LocalNewsFeedGatewayImpTest {

  private LocalNewsFeedGateway gateway;

  @Before public void setUp() throws Exception {
    initGateway();
  }

  @After public void tearDown() throws Exception {
    Realm realm = Realm.getInstance(buildConfiguration());
    realm.beginTransaction();
    realm.deleteAll();
    realm.commitTransaction();
    realm.close();
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
    gateway = new LocalNewsFeedGatewayImp(new FeedOperation(buildConfiguration()));
  }

  private RealmConfiguration buildConfiguration() {
    return new RealmConfiguration.Builder(
        InstrumentationRegistry.getContext()).deleteRealmIfMigrationNeeded().build();
  }
}