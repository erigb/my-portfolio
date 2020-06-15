// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import java.io.IOException;
import com.google.sps.data.Comment;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    private Comment myData;

  @Override
  public void init() {
    myData = new Comment();

  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    myData = new Comment();
    //Sets up datastore output.
    Query query = new Query("Comment").addSort("timestamp", SortDirection.DESCENDING);
    DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
    PreparedQuery results = datastore.prepare(query);

    //Adds each comment on the database to the client.
    for (Entity entity : results.asIterable()) {
        String name = (String) entity.getProperty("name");
        String location = (String) entity.getProperty("location");
        String comment = (String) entity.getProperty("comment");

        myData.addName(name);
        myData.addLocation(location);
        myData.addComment(comment);
    }

    response.setContentType("application/json");
    String json = new Gson().toJson(myData);
    response.getWriter().println(json);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      //Gets comment from client.
      String name = getParameter(request, "name-area", "");
      String location = getParameter(request, "location-area", "");
      String comment = getParameter(request, "comment-area", "");
      long timestamp = System.currentTimeMillis();
      
      //Sets up datastore.
      Entity taskEntity = new Entity("Comment");
      taskEntity.setProperty("name", name);
      taskEntity.setProperty("location", location);
      taskEntity.setProperty("comment", comment);
      taskEntity.setProperty("timestamp", timestamp);

      DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
      datastore.put(taskEntity);

      response.sendRedirect("/index.html");  //Change this when using actual clinet/server
  }

   /**
   * Converts a ServerStats instance into a JSON string using manual String concatentation.
   * This is not used anymore since I switched to Gson. Should I delete it?
   */
  private String convertToJson(ArrayList<String> myData) {

    String json = "[";
    json += "{";
    json += "\"name\": ";
    json += "\"" + myData.get(0) + "\"";
    json += ", ";
    json += "\"location\": ";
    json += "\"" + myData.get(1) + "\"";
    json += ", ";
    json += "\"comment\": ";
    json += "\"" + myData.get(2) + "\"";
    json += "}";
    json += "]";
     return json;
  }

   /**
   * @return the request parameter, or the default value if the parameter
   *         was not specified by the client
   */
  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
}
