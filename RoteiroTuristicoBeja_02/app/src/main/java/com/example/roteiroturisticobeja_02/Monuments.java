package com.example.roteiroturisticobeja_02;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Monuments {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String monument_name;
    private String description;
    private String image;

    public Monuments(long id, String monument_name, String description, String image) {
        this.id = id;
        this.monument_name = monument_name;
        this.description = description;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public String getMonument_name() {
        return monument_name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
