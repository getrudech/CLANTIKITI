package com.example.clantikiti.models;

import org.parceler.Parcel;

@Parcel
public class Events {
    /*id SERIAL PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    location VARCHAR,
    price INT*/

    private int id;
    private String name;
    private String description;
    private String location;
    private int price;

    public Events() {}

    public Events(String name, String description, String location, int price) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public int getId() {
        return id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }
}
