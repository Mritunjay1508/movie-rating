package com.movieratingapp.application.service;

import com.movieratingapp.application.entity.MovieEntity;

import java.util.List;

public interface MovieService {

    MovieEntity createMovie(String movieName, String pincode);

    List<MovieEntity> getAllMovies();

    MovieEntity getMovieById(Long movieId);

    List<MovieEntity> getMoviesByPincode(String pincode);
}
