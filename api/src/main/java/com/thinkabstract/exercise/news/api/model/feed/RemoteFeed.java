package com.thinkabstract.exercise.news.api.model.feed;

import com.google.gson.annotations.SerializedName;
import com.thinkabstract.exercise.news.domain.model.Feed;
import java.util.ArrayList;
import java.util.List;

public class RemoteFeed {

  @SerializedName("feedUrl") public String feedURl;

  @SerializedName("title") public String title;

  @SerializedName("link") public String link;

  @SerializedName("author") public String author;

  @SerializedName("description") public String description;

  @SerializedName("type") public String type;

  @SerializedName("entries") public List<RemoteFeedEntry> entries;

  public Feed map() {
    Feed feed = new Feed();
    feed.title = title;
    feed.description = description;
    feed.entries = new ArrayList<>();
    for (RemoteFeedEntry entry : entries) {
      feed.entries.add(entry.map());
    }
    return feed;
  }
}
