package com.thinkabstract.exercise.news.persistence.model;

import io.realm.RealmList;
import io.realm.RealmObject;

public class PersistableFeed extends RealmObject {

  public String title;

  public String description;

  public RealmList<PersistableFeedEntry> entries;
}
