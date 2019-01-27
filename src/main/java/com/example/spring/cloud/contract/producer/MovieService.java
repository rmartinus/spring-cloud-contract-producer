package com.example.spring.cloud.contract.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Long saveMovie(Movie movie) {
        MovieEntity save = movieRepository.save(new MovieEntity(null, movie.getName(), movie.getGenre(), movie.getYear()));
        return save.getId();
    }

    public Movie getMovie(String movieId) {
        MovieEntity movieEntity = movieRepository.findById(Long.valueOf(movieId)).get();
        return new Movie(String.valueOf(movieId), movieEntity.getName(), movieEntity.getGenre(), movieEntity.getYear());
    }
}