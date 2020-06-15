/*
*This class is in charge of each comment object.
*/
package com.google.sps.data;
import java.util.ArrayList;
import java.util.List;


public class Comment  {
    private final List<String> name = new ArrayList<>();
    private final List<String> location = new ArrayList<>();
    private final List<String> comment = new ArrayList<>();

    public void addName(String n)  {
        name.add(n);
    }

    public void addLocation(String n)  {
        location.add(n);
    }

    public void addComment(String n)  {
        comment.add(n);
    }
}