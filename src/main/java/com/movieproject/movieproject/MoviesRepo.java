package com.movieproject.movieproject;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MoviesRepo extends MongoRepository<Movie, String> {


}
