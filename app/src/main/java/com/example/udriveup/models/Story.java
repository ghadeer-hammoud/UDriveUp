package com.example.udriveup.models;

public class Story {

    private String imageUrl;
    private String username;

    public Story(String imageUrl, String username) {
        this.imageUrl = imageUrl;
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
