package com.thinkabstract.exercise.news.api.model.query;

import com.thinkabstract.exercise.news.api.model.*;
import com.thinkabstract.exercise.news.domain.model.QueryResult;
import java.util.ArrayList;
import java.util.List;

public class RemoteQueryResponse extends RemoteResponse<RemoteQueryResponseData> {

  public List<QueryResult> map() {
    List<QueryResult> mappedResult = new ArrayList<>();
    for (RemoteQueryEntry entity : responseData.entries) {
      mappedResult.add(entity.map());
    }
    return mappedResult;
  }
}
