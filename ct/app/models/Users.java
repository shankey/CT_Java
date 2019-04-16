package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;

//import io.ebean.*;

@Entity
public class Users extends Model {

    @Id
    @Constraints.Min(10)
    public Long id;

    public String name;

    public String email;

    public String profile_pictures;

    public String blog_cover_image;

    public static final Finder<Long, Users> find = new Finder<>(Users.class);

    @Override
    public String toString() {
        return id + " " + name + " " + email + " " + profile_pictures + " " + blog_cover_image;
    }
}