package com.thinkabstract.exercise.news.persistence.mapper;

import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.model.FeedEntry;
import com.thinkabstract.exercise.news.persistence.model.PersistableFeed;
import com.thinkabstract.exercise.news.persistence.model.PersistableFeedEntry;
import io.realm.RealmList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersistableFeedMapper {

  public static PersistableFeed mapFeed(Feed feed) {
    PersistableFeed persistableFeed = new PersistableFeed();
    persistableFeed.title = feed.title;
    persistableFeed.description = feed.description;
    persistableFeed.entries = buildMapPersistableEntries(feed.entries);
    return persistableFeed;
  }

  public static List<Feed> mapPersistableFeedList(List<PersistableFeed> persistableFeeds) {
    List<Feed> feeds = new ArrayList<>();
    if (persistableFeeds != null) {
      for (PersistableFeed persistableFeed : persistableFeeds) {
        Feed feed = new Feed();
        feed.title = persistableFeed.title;
        feed.description = persistableFeed.description;
        feed.entries = buildFeedEntries(persistableFeed.entries);
        feeds.add(feed);
      }
    }
    return feeds;
  }

  private static List<FeedEntry> buildFeedEntries(
      List<PersistableFeedEntry> persistableFeedEntries) {
    List<FeedEntry> entries = new ArrayList<>();
    if (persistableFeedEntries != null) {
      for (PersistableFeedEntry persistableFeedEntry : persistableFeedEntries) {
        FeedEntry entry = new FeedEntry();
        entry.title = persistableFeedEntry.title;
        entry.contentSnippet = persistableFeedEntry.contentSnippet;
        entry.content = persistableFeedEntry.content;
        entry.publishedDate = new Date(persistableFeedEntry.publishedDate);
        entries.add(entry);
      }
    }
    return entries;
  }

  private static RealmList<PersistableFeedEntry> buildMapPersistableEntries(List<FeedEntry> entries) {
    RealmList<PersistableFeedEntry> persistableFeedEntries = new RealmList<>();
    if (entries != null) {
      for (FeedEntry entry : entries) {
        persistableFeedEntries.add(buildFeedEntry(entry));
      }
    }
    return persistableFeedEntries;
  }

  private static PersistableFeedEntry buildFeedEntry(FeedEntry entry) {
    PersistableFeedEntry persistableFeedEntry = new PersistableFeedEntry();
    persistableFeedEntry.title = entry.title;
    persistableFeedEntry.contentSnippet = entry.contentSnippet;
    persistableFeedEntry.content = entry.content;
    persistableFeedEntry.publishedDate = entry.publishedDate.getTime();
    return persistableFeedEntry;
  }
}
