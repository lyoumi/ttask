package com.moviesfan.test.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviesfan.test.dto.Actor;
import com.moviesfan.test.dto.FavoriteActors;
import com.moviesfan.test.service.ActorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("favorites/actors")
@AllArgsConstructor
public class ActorResource {

    private final ActorService actorService;

    @GetMapping
    public FavoriteActors favoriteActors() {
        return actorService.getFavoriteActors();
    }

    /**
     * I'd like to believe that the same method can be used to delete actor from favorites
     * @param actor
     * @return
     */
    @PutMapping
    public Actor addToFavorites(@RequestBody Actor actor) {
        return actorService.updateFavoriteActors(actor);
    }
}
