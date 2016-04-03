package com.thinkabstract.exercise.news.api.model.query;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class RemoteQueryResponseData {
  @SerializedName("query") public String query;

  @SerializedName("entries") public List<RemoteQueryEntry> entries;
}
