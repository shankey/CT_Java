package pojo;

public class TravelStoryOut {

    public Long Id;

    public String title;

    public String location;

    public String image;

    public String story;

    public String normalizedlocation;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getNormalizedlocation() {
        return normalizedlocation;
    }

    public void setNormalizedlocation(String normalizedlocation) {
        this.normalizedlocation = normalizedlocation;
    }

    public String toString(){
        return title + " " + location + " " + normalizedlocation;
    }
}
