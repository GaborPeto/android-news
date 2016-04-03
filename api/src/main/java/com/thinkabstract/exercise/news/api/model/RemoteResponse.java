package com.thinkabstract.exercise.news.api.model;

import com.google.gson.annotations.SerializedName;

public class RemoteResponse<T> {

  @SerializedName("responseDetails") public String responseDetails;

  @SerializedName("responseStatus") public int responseStatus;

  @SerializedName("responseData") public T responseData;
}

