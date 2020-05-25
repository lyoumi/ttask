package com.moviesfan.test.service;

import com.moviesfan.test.dto.Actor;
import com.moviesfan.test.dto.FavoriteActors;

public interface ActorService {

    FavoriteActors getFavoriteActors();

    Actor updateFavoriteActors(Actor actor);
}
