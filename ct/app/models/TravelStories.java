package models;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import javax.persistence.*;

//import io.ebean.*;
import io.ebean.Finder;
import io.ebean.Model;
import play.data.format.*;
import play.data.validation.*;

@Entity
public class TravelStories extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    public Long userId;

    public Long completed;

    public Long live;

    public String title;

    public String location;

    public String image;

    public String story;

    public static final Finder<Long, TravelStories> find = new Finder<>(TravelStories.class);

    public String getImage(){
        try {
            if(image!=null){
                String result = java.net.URLDecoder.decode(image, StandardCharsets.UTF_8.name());
                //return result;
            }

        } catch (UnsupportedEncodingException e) {
            // not going to happen - value came from JDK's own StandardCharsets
        }
        return image;
    }

    @Override
    public String toString() {
        return id + " " + userId + " " + title + " " + location + " " + image + " " + completed + " " + live;
    }
}