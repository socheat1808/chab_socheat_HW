package com.example.loginscreen;

import java.io.Serializable;

public class MovieModel implements Serializable {
    private final double rating;
    private final String type;      // "Premium" or "Free"
    private final String title;
    private final int year;
    private final int duration;     // minutes
    private final String ageRating;
    private final String genre;
    private final int imageRes;

    public MovieModel(double rating, String type, String title, int year,
                      int duration, String ageRating, String genre, int imageRes) {
        this.rating = rating;
        this.type = type;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genre = genre;
        this.imageRes = imageRes;
    }

    public double getRating() { return rating; }
    public String getType() { return type; }
    public String getTitle() { return title; }
    public int getYear() { return year; }
    public int getDuration() { return duration; }
    public String getAgeRating() { return ageRating; }
    public String getGenre() { return genre; }
    public int getImageRes() { return imageRes; }
    public boolean isPremium() { return "Premium".equalsIgnoreCase(type); }
}
