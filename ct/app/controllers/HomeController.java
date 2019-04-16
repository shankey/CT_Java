package controllers;

import models.TravelStories;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import play.libs.Json;
import play.mvc.*;
import pojo.TravelStoryOut;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result story(Long id) {

        TravelStories ts = TravelStories.find.byId(id);

        TravelStoryOut tso = initTravelStoryOut(ts);

        return ok(Json.prettyPrint(Json.toJson(tso)));

    }


    public Result userstories() {

        List<TravelStories> tsList = TravelStories.find.query().where()
                .eq("userId", new Long(2))
                .eq("live", new Long(1))
                .findList();

        List<TravelStoryOut> tsos = new ArrayList<TravelStoryOut>();

        for(TravelStories ts: tsList){
            tsos.add(initTravelStoryOut(ts));
        }

        return ok(Json.prettyPrint(Json.toJson(tsos)));

    }


    private TravelStoryOut initTravelStoryOut(TravelStories ts){
        TravelStoryOut tso = new TravelStoryOut();
        tso.setId(ts.id);
        tso.setImage(ts.getImage());
        tso.setLocation(ts.location);
        tso.setNormalizedlocation(normalizeLocation(ts));
        tso.setStory(ts.story);
        tso.setTitle(ts.title);

        return tso;
    }

    private String normalizeLocation(TravelStories ts){
        String location = ts.location;
        location = location.replaceAll("<br>", " ");
        location = location.replaceAll("\\s+", " ");

        return location;
    }

    public Result migratestories() {

        List<TravelStories> li = TravelStories.find.all();

        for (TravelStories ts: li){
            Long sid = ts.id;
            //String path = "./public/places/" + sid.toString() + "/_story.html.erb";
            String path = "./public/places/" + sid.toString() + "/_title.html.erb";
            Document doc = null;
            try {
                File input = new File(path);
                doc = Jsoup.parse(input, "UTF-8", "");
                Elements story = doc.select("h3");
                System.out.println(sid);
                byte ptext[] = story.get(0).text().getBytes("ISO-8859-1");
                String value = new String(ptext, "UTF-8");
                ts.title = value;
                ts.save();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return ok(
                Json.prettyPrint(
                        Json.toJson(TravelStories.find.all())
                )
        );

    }

}
