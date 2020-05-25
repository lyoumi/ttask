package com.moviesfan.test.service;

import org.springframework.stereotype.Service;

import com.moviesfan.test.dto.Actor;

import com.moviesfan.test.dto.FavoriteActors;
import com.moviesfan.test.exception.UnableToUpdateFavoriteActorsException;
import com.moviesfan.test.feign.MovieServiceClient;

import java.util.UUID;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final MovieServiceClient movieServiceClient;

    @Override
    public FavoriteActors getFavoriteActors() {
        /**
         * Currently we are getting token using UUID.randomUUID, but in real application we'll have
         * security filter with setting user token to securityContext.
         */
        final String token = UUID.randomUUID().toString();
        return movieServiceClient.favoriteActors(token);
    }

    @Override
    public Actor updateFavoriteActors(Actor actor) {
        if (null != movieServiceClient.updateFavoriteActors(actor.getId(), UUID.randomUUID().toString())) {
            return actor;
        } else {
            throw new UnableToUpdateFavoriteActorsException(String.format("Unable to add actor with id %s to favorites", actor.getId()));
        }
    }
}
