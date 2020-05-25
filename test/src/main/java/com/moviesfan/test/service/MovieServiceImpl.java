package com.moviesfan.test.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.moviesfan.test.dto.FavoriteMovies;
import com.moviesfan.test.dto.Movie;
import com.moviesfan.test.exception.UnableToUpdateFavoriteMoviesException;
import com.moviesfan.test.feign.MovieServiceClient;

import java.util.UUID;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieServiceClient movieServiceClient;

    @Override
    public FavoriteMovies getFavoriteMovies() {
        /**
         * Currently we are getting token using UUID.randomUUID, but in real application we'll have
         * security filter with setting user token to securityContext.
         */
        final String token = UUID.randomUUID().toString();
        return movieServiceClient.favoriteMovies(token);
    }

    @Override
    public Movie updateFavoritesMovies(Movie movie) {
        if (!StringUtils.isEmpty(movieServiceClient.updateFavoriteMovies(movie.getId(), UUID.randomUUID().toString()))) {
            return movie;
        } else {
            throw new UnableToUpdateFavoriteMoviesException(String.format("Unable to add actor with id %s to favorites", movie.getId()));
        }
    }
}
