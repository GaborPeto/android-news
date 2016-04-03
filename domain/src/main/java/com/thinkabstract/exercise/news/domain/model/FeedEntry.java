package com.thinkabstract.exercise.news.domain.model;

import java.util.Date;

public class FeedEntry {

  public String title;

  public String contentSnippet;

  public String content;

  public Date publishedDate;

  @Override public String toString() {
    return "FeedEntry{" +
        "title='" + title + '\'' +
        ", contentSnippet='" + contentSnippet + '\'' +
        ", content='" + content + '\'' +
        ", publishedDate=" + publishedDate +
        '}';
  }

  @Override public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    FeedEntry feedEntry = (FeedEntry) o;

    if (title != null ? !title.equals(feedEntry.title) : feedEntry.title != null) {
      return false;
    }
    if (contentSnippet != null
        ? !contentSnippet.equals(feedEntry.contentSnippet)
        : feedEntry.contentSnippet != null) {
      return false;
    }
    if (content != null ? !content.equals(feedEntry.content) : feedEntry.content != null) {
      return false;
    }
    return publishedDate != null
        ? publishedDate.equals(feedEntry.publishedDate)
        : feedEntry.publishedDate == null;
  }

  @Override public int hashCode() {
    int result = title != null ? title.hashCode() : 0;
    result = 31 * result + (contentSnippet != null ? contentSnippet.hashCode() : 0);
    result = 31 * result + (content != null ? content.hashCode() : 0);
    result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
    return result;
  }
}
