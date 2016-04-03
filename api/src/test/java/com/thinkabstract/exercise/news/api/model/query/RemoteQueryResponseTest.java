package com.thinkabstract.exercise.news.api.model.query;

import com.thinkabstract.exercise.news.api.model.BaseModelTest;
import com.thinkabstract.exercise.news.domain.model.QueryResult;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoteQueryResponseTest extends BaseModelTest {

  private static final int RESULT_COUNT = 10;
  private static final String RESULT_URL = "http://feeds.visitlondon.com/WhatsOnInLondon";
  private static final String RESULT_TITLE =
      "visitlondon.com Your Official London City Guide";
  private static final String RESULT_CONTENT_SNIPPET =
      "Plan and book your trip to London with the official London city guide. Discover things to do, whats on, sightseeing attractions, tours, tickets and more.";

  @Test public void testMap() throws Exception {
    RemoteQueryResponse response =
        gson.fromJson(readFile("/remote_query_response.json"), RemoteQueryResponse.class);

    List<QueryResult> resultList = response.map();

    assertEquals(RESULT_COUNT, resultList.size());
    QueryResult result = resultList.get(0);
    assertEquals(RESULT_URL, result.url);
    assertEquals(RESULT_TITLE, result.title);
    assertEquals(RESULT_CONTENT_SNIPPET, result.contentSnippet);
  }
}