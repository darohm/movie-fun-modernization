package org.superbiz.moviefun.moviesapi;

import java.util.Objects;

public class MovieInfo {
    private long id;
    private String director;
    private String title;
    private int year;
    private String genre;
    private int rating;

    public MovieInfo(){}

    public MovieInfo(String title, String director, String genre, int rating, int year) {
        this.director = director;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieInfo)) return false;
        MovieInfo movieInfo = (MovieInfo) o;
        return id == movieInfo.id &&
                year == movieInfo.year &&
                rating == movieInfo.rating &&
                director.equals(movieInfo.director) &&
                title.equals(movieInfo.title) &&
                genre.equals(movieInfo.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, director, title, year, genre, rating);
    }
}
