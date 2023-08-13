package com.movieratingapp.application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ratings")
public class RatingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ratingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private MovieEntity movieId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "userName")
    private String userName;

    private int ratingValue;

    private String reviewComments;

    @Column(name = "submission_time")
    private LocalDateTime submissionTime;

    public RatingEntity() {

    }

    public RatingEntity(MovieEntity movieId, Long userId, String userName, int ratingValue, String reviewComments) {
        this.movieId = movieId;
        this.userId = userId;
        this.userName = userName;
        this.ratingValue = ratingValue;
        this.reviewComments = reviewComments;
        this.submissionTime = LocalDateTime.now();
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
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

    public LocalDateTime getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(LocalDateTime submissionTime) {
        this.submissionTime = submissionTime;
    }
}
