package com.movieratingapp.application.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

import com.movieratingapp.application.entity.MovieEntity;
import com.movieratingapp.application.repository.MovieRepository;
import com.movieratingapp.application.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @Test
    public void testCreateMovie() {
        String movieName = "Test Movie";
        String pincode = "12345";
        MovieEntity mockMovie = new MovieEntity(movieName, pincode);
        when(movieRepository.save(any(MovieEntity.class))).thenReturn(mockMovie);// Act
        MovieEntity result = movieService.createMovie(movieName, pincode);
        verify(movieRepository, times(1)).save(any(MovieEntity.class));
        assertEquals(movieName, result.getMovieName());
        assertEquals(pincode, result.getPincode());
    }
    @Test
    public void testGetAllMovies() {
        List<MovieEntity> expectedMovies = new ArrayList<>();
        expectedMovies.add(new MovieEntity("Movie 1", "12345"));
        expectedMovies.add(new MovieEntity("Movie 2", "67890"));
        when(movieRepository.findAll()).thenReturn(expectedMovies);
        List<MovieEntity> result = movieService.getAllMovies();
        assertNotNull(result);
        assertEquals(expectedMovies, result);
        assertEquals(expectedMovies.size(), result.size());
        verify(movieRepository, times(1)).findAll();
    }

}
