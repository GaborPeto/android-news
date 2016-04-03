package com.thinkabstract.exercise.news.persistence.model;

import io.realm.RealmObject;
import java.util.Date;

public class PersistableFeedEntry extends RealmObject {

  public String title;

  public String contentSnippet;

  public String content;

  public Date publishedDate;
}
