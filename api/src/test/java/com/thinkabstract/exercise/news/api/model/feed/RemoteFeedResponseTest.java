package com.thinkabstract.exercise.news.api.model.feed;

import com.thinkabstract.exercise.news.api.model.BaseModelTest;
import com.thinkabstract.exercise.news.domain.model.Feed;
import com.thinkabstract.exercise.news.domain.model.FeedEntry;
import java.util.Date;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoteFeedResponseTest extends BaseModelTest {

  private static final String FEED_TITLE = "What's On in London";
  private static final String FEED_DESCRIPTION =
      "London hosts thousands of exciting events and activities.";
  private static final int FEED_ENTRIES_COUNT = 4;
  private static final String FEED_ENTRY_TITLE = "FIH Women's Hockey World Cup 2018";
  private static final String FEED_CONTENT_SNIPET =
      "London will host hockey's biggest tournament outside the Olympics from the 7 Jul to 21 Jul 2017";
  private static final String FEED_CONTENT =
      "London will host hockey's biggest tournament outside the Olympics from the 7 Jul to 21 Jul 2017 -";
  private static final Date FEED_PUBLISHED_DATE = new Date(1446217996000L);

  @Test public void testMap() throws Exception {
    RemoteFeedResponse response =
        gson.fromJson(readFile("/remote_feed_response.json"), RemoteFeedResponse.class);

    Feed feed = response.map();

    assertEquals(FEED_TITLE, feed.title);
    assertEquals(FEED_DESCRIPTION, feed.description);
    assertEquals(FEED_ENTRIES_COUNT, feed.entries.size());

    FeedEntry feedEntry = feed.entries.get(0);
    assertEquals(FEED_ENTRY_TITLE, feedEntry.title);
    assertEquals(FEED_CONTENT_SNIPET, feedEntry.contentSnippet);
    System.out.println(feedEntry.content);
    assertEquals(FEED_CONTENT, feedEntry.content);
    assertEquals(FEED_PUBLISHED_DATE, feedEntry.publishedDate);
  }
}