package com.thinkabstract.exercise.news.api.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.junit.Before;

public abstract class BaseModelTest {

  private static final String DEFAULT_CHARSET = "UTF-8";

  protected Gson gson;

  @Before public void setUp() throws Exception {
    gson = new GsonBuilder().create();
  }

  protected static String readFile(String path) {
    return inputStreamToString(BaseModelTest.class.getResourceAsStream(path));
  }

  private static String inputStreamToString(InputStream inputStream) {
    StringBuilder fileData = new StringBuilder();
    String currentLine;
    try {
      BufferedReader bufferedReader =
          new BufferedReader(new InputStreamReader(inputStream, DEFAULT_CHARSET));
      while ((currentLine = bufferedReader.readLine()) != null) {
        fileData.append(currentLine).append("\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return fileData.toString();
  }
}
