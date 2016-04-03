package com.thinkabstract.exercise.news.domain.model;

import java.util.List;

public class Feed {

  public String title;

  public String description;

  public List<FeedEntry> entries;

  @Override public String toString() {
    return "Feed{" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", entries=" + entries +
        '}';
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Feed feed = (Feed) o;

    if (title != null ? !title.equals(feed.title) : feed.title != null) {
      return false;
    }
    if (description != null ? !description.equals(feed.description) : feed.description != null) {
      return false;
    }
    return entries != null ? entries.equals(feed.entries) : feed.entries == null;
  }

  @Override public int hashCode() {
    int result = title != null ? title.hashCode() : 0;
    result = 31 * result + (description != null ? description.hashCode() : 0);
    result = 31 * result + (entries != null ? entries.hashCode() : 0);
    return result;
  }
}
