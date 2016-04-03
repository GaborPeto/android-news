package com.thinkabstract.exercise.news.api.model.feed;

import com.google.gson.annotations.SerializedName;
import com.thinkabstract.exercise.news.domain.model.FeedEntry;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class RemoteFeedEntry {

  private static final SimpleDateFormat DATE_FORMAT =
      new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);

  @SerializedName("title") public String title;

  @SerializedName("link") public String link;

  @SerializedName("author") public String author;

  @SerializedName("publishedDate") public String publishedDate;

  @SerializedName("contentSnippet") public String contentSnippet;

  @SerializedName("content") public String content;

  @SerializedName("categories") public List<RemoteFeedCategory> categories;

  public FeedEntry map() {
    FeedEntry entry = new FeedEntry();
    entry.title = title;
    entry.contentSnipet = contentSnippet;
    entry.content = content;
    parseDate(entry);
    return entry;
  }

  private void parseDate(FeedEntry entry) {
    DateFormat format = DATE_FORMAT;
    try {
      entry.publishedDate = format.parse(publishedDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
