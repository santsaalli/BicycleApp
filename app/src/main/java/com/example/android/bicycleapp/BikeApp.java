package com.example.android.bicycleapp;

import android.content.Intent;

public class BikeApp {

    private int serialn;

    private String title;
    private String description;
    private double rating;

    public BikeApp(int serialn, String title, String description, double rating) {
        this.serialn = serialn;
        this.title = title;
        this.description = description;
        this.rating = rating;
    }

    public BikeApp(Intent intent) {
        serialn = intent.getIntExtra(MainActivity.EXTRA_SERIAL_NUMBER, 0);
        title = intent.getStringExtra(MainActivity.EXTRA_TITLE);
        description = intent.getStringExtra(MainActivity.EXTRA_DESC);
        rating = intent.getDoubleExtra(MainActivity.EXTRA_RATINGS, 0);
    }

    public int getserialn() {
        return serialn;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getrating() {
        return rating;
    }

    public String getImageName() {
        return "image_" + serialn;
    }

    @Override
    public String toString() {
        return title;
    }
}
