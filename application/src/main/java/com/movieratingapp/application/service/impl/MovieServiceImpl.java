package com.movieratingapp.application.service.impl;

import com.movieratingapp.application.entity.MovieEntity;
import com.movieratingapp.application.exception.ResourceNotFoundException;
import com.movieratingapp.application.repository.MovieRepository;
import com.movieratingapp.application.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public MovieEntity createMovie(String movieName, String pincode) {
        MovieEntity movie = new MovieEntity(movieName, pincode);
        return movieRepository.save(movie);
    }

    @Override
    public List<MovieEntity> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public MovieEntity getMovieById(Long movieId) {
        return movieRepository.findById(movieId).orElseThrow(() ->
                new ResourceNotFoundException("Movie not found with the" +
                        "provided Id"));
    }

    @Override
    public List<MovieEntity> getMoviesByPincode(String pincode) {
        return movieRepository.findByPincode(pincode);
    }

}
