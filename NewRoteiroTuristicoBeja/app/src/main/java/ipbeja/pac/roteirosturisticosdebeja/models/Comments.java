package ipbeja.pac.roteirosturisticosdebeja.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Comments {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long user_id;
    private long monument_id;
    private String comment;

    public Comments(long id,long user_id, long monument_id, String comment) {
        this.id = id;
        this.user_id = user_id;
        this.monument_id = monument_id;
        this.comment = comment;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getMonument_id() {
        return monument_id;
    }

    public void setMonument_id(long monument_id) {
        this.monument_id = monument_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
