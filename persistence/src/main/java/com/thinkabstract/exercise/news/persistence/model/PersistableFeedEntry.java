package com.thinkabstract.exercise.news.persistence.model;

import io.realm.RealmObject;

public class PersistableFeedEntry extends RealmObject {

  public String title;

  public String contentSnippet;

  public String content;

  public long publishedDate;
}
