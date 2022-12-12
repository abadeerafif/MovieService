package com.movieproject.movieproject;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesDatabaseService {
	
	@Autowired
	private MoviesRepo moviesRepo;	
	
	
	public List<Movie> GetMovies()
	{
		
		
		return moviesRepo.findAll();
		
		
		
	}
	
	public Optional<Movie> GetMovieByName(String name)
	{
		return moviesRepo.findById(name);
		
		
	}
	public void AddMovie(Movie movie)
	{
		moviesRepo.save(movie);
		
	}
	public void DeleteMovie(String movie_name)
	{
		moviesRepo.deleteById(movie_name);
		
	}
	public void UpdateMovie(String movie_name,Movie updatedMovie)
	{
		
		moviesRepo.save(updatedMovie);
		if(!movie_name.equals(updatedMovie.getMovieName()))
		{
			DeleteMovie(updatedMovie.getMovieName());
			
		}
		
	}


}
