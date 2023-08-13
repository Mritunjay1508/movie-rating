package com.movieratingapp.application.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;

    private String movieName;

    private String pincode;

    @OneToMany(mappedBy = "movieId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<RatingEntity> ratings = new ArrayList<>();

    public MovieEntity() {

    }

    public MovieEntity(String movieName, String pincode) {
        this.movieName = movieName;
        this.pincode = pincode;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public List<RatingEntity> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingEntity> ratings) {
        this.ratings = ratings;
    }

    public void addRatings(RatingEntity rating) {
        ratings.add(rating);
        rating.setMovieId(this);
    }

    public void removeRating(RatingEntity rating) {
        ratings.remove(rating);
        rating.setMovieId(null);
    }
}
