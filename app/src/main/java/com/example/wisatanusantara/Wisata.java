package com.example.wisatanusantara;

public class Wisata {
    private String title;
    private String info;
    private final int imageResource;

    public Wisata(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    String getTitle() {
        return title;
    }


    String getInfo() {
        return info;
    }
}
