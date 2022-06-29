package ipbeja.pac.roteirosturisticosdebeja.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Monuments {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String monument_name;
    private String monument_descriptions;
    private String coordinates;
    private int likes;
    private int dislikes;
    private String image;

    public Monuments(long id, String monument_name, String monument_descriptions, String coordinates ,int likes, int dislikes, String image) {
        this.id = id;
        this.monument_name = monument_name;
        this.monument_descriptions = monument_descriptions;
        this.coordinates = coordinates;
        this.likes = likes;
        this.dislikes = dislikes;
        this.image = image;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMonument_name() {
        return monument_name;
    }

    public void setMonument_name(String monument_name) {
        this.monument_name = monument_name;
    }

    public String getMonument_descriptions() {
        return monument_descriptions;
    }

    public void setMonument_descriptions(String monument_descriptions) {
        this.monument_descriptions = monument_descriptions;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
