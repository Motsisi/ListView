package com.cet.listview;

public class User {

    int image;
    String name;
    String time;
    String message;

    public User(int image, String name, String time, String message) {
        this.image = image;
        this.name = name;
        this.time = time;
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
