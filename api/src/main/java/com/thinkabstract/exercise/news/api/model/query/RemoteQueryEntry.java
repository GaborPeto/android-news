package com.thinkabstract.exercise.news.api.model.query;

import com.google.gson.annotations.SerializedName;
import com.thinkabstract.exercise.news.domain.model.QueryResult;

public class RemoteQueryEntry {

  @SerializedName("url") public String url;

  @SerializedName("title") public String title;

  @SerializedName("contentSnippet") public String contentSnippet;

  @SerializedName("link") public String link;

  public QueryResult map() {
    QueryResult result = new QueryResult();
    result.url = url;
    result.title = title;
    result.contentSnippet = contentSnippet;
    return result;
  }
}
