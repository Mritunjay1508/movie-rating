package com.movieratingapp.application.dto;

import com.movieratingapp.application.entity.MovieEntity;

public class RatingDTO {

    private MovieEntity movieId;
    private Long userId;
    private String userName;
    private int ratingValue;
    private String reviewComments;

    public RatingDTO() {

    }

    public RatingDTO(MovieEntity movieId, Long userId, String userName, int ratingValue, String reviewComments) {
        this.movieId = movieId;
        this.userId = userId;
        this.ratingValue = ratingValue;
        this.reviewComments = reviewComments;
        this.userName = userName;
    }

    public MovieEntity getMovieId() {
        return movieId;
    }

    public void setMovieId(MovieEntity movieId) {
        this.movieId = movieId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRatingValue() {
        return ratingValue;
    }

    public void setRatingValue(int ratingValue) {
        this.ratingValue = ratingValue;
    }

    public String getReviewComments() {
        return reviewComments;
    }

    public void setReviewComments(String reviewComments) {
        this.reviewComments = reviewComments;
    }
}
