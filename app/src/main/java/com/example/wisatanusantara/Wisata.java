package com.example.wisatanusantara;

class Wisata {
    private String title;
    private final int imageResource;

    public Wisata(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public int getImageResource() {
        return imageResource;
    }

    String getTitle() {
        return title;
    }
}
