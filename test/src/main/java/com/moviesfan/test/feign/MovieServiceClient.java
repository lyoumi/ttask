package com.moviesfan.test.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.moviesfan.test.dto.FavoriteActors;
import com.moviesfan.test.dto.FavoriteMovies;

/**
 * I hope, that in production implementation @RequestHeader should be replaced with RequestInterceptor
 */
@FeignClient(name = "MovieServiceClient", url = "http://localhost:9443")
public interface MovieServiceClient {

    @GetMapping("/favorites/actors")
    FavoriteActors favoriteActors(@RequestHeader("token") String token);

    @PutMapping("/favorites/actors/{id}")
    String updateFavoriteActors(@PathVariable("id") String id, @RequestHeader("auth_token") String token);

    @GetMapping("/favorites/movies")
    FavoriteMovies favoriteMovies(@RequestHeader("auth_token") String token);

    @PutMapping("/favorites/movies/{id}")
    String updateFavoriteMovies(@PathVariable("id") String id, @RequestHeader("auth_token") String token);
}
