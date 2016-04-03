package com.thinkabstract.exercise.news.persistence.operation.feed;

import com.thinkabstract.exercise.news.persistence.model.PersistableFeed;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.util.List;
import javax.inject.Inject;

public class FeedOperation {

  private RealmConfiguration configuration;

  @Inject public FeedOperation(RealmConfiguration configuration) {
    this.configuration = configuration;
  }

  public List<PersistableFeed> query() {
    Realm realm = getRealm();
    try {
      return realm.copyFromRealm(realm.allObjects(PersistableFeed.class));
    } finally {
      realm.close();
    }
  }

  public void saveFeed(PersistableFeed feed) {
    Realm realm = getRealm();
    try {
      realm.beginTransaction();
      realm.copyToRealm(feed);
      realm.commitTransaction();
    } finally {
      realm.close();
    }
  }

  private Realm getRealm() {
    return Realm.getInstance(configuration);
  }
}
