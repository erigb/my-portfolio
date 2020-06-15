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

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {

    private ArrayList<String> myData;

  @Override
  public void init() {
    myData = new ArrayList<>();
    // myData.add("Ethan Rigby");
    // myData.add("London, Ontario");
    // myData.add("September 17, 1999");

  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String json = convertToJson(myData);
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      String name = getParameter(request, "name-area", "");
      String location = getParameter(request, "location-area", "");
      String comment = getParameter(request, "comment-area", "");

      myData.add(name);
      myData.add(location);
      myData.add(comment);

      response.sendRedirect("https://8080-dot-12501279-dot-devshell.appspot.com/?authuser=0");  //Change this when using actual clinet/server
  }

   /**
   * Converts a ServerStats instance into a JSON string using manual String concatentation.
   */
  private String convertToJson(ArrayList<String> myData) {
    String json = "{";
    json += "\"name\": ";
    json += "\"" + myData.get(0) + "\"";
    json += ", ";
    json += "\"location\": ";
    json += "\"" + myData.get(1) + "\"";
    json += ", ";
    json += "\"comment\": ";
    json += "\"" + myData.get(2) + "\"";
    json += "}";
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
