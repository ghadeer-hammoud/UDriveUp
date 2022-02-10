package com.example.udriveup.models;

public class Category {

    private String iconUrl;
    private String title;

    public Category(String iconUrl, String title) {
        this.iconUrl = iconUrl;
        this.title = title;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
