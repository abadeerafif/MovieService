package com.movieproject.movieproject;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movieproject.MovieToken;

import ch.qos.logback.core.subst.Token;

@RestController
@CrossOrigin
public class MovieController {
	
	@Autowired
	private MoviesDatabaseService service;
	
	@RequestMapping(method=RequestMethod.POST,value = "/getMovies")
	public List<Movie> GetMovies(@RequestBody MovieToken token)
	{
		String uri="http://localhost:7000/tokencheck/"+token.email+"/"+token.token;
		RestTemplate restTemplate=new RestTemplate();
		boolean result=restTemplate.getForObject(uri, boolean.class);
		if(result==true)
		{
			return service.GetMovies();

		}
		else
		{
			return null;
		}
		
		
		
	}
	@RequestMapping("/Movies/{name}") //not used just for learning 
	public Optional<Movie> GetMovieByName(@PathVariable String name)
	{
		return service.GetMovieByName(name);
		
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/Movies")
	public void AddMovie(@RequestBody Movie movie)
	{
		// TODO use ResponseEntity
		// return ResponseEntity.status(OK).body(service.AddMovie(movie));
		service.AddMovie(movie);
		
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/Movies/{movie_name}")
	public void DeleteMovie(@PathVariable String movie_name)
	{
		service.DeleteMovie(movie_name);
		
	}
	@RequestMapping(method=RequestMethod.PUT,value="/Movies/{movie_name}")
	public void UpdateMovie(@PathVariable String movie_name, @RequestBody Movie updatedMovie)
	{
		service.UpdateMovie(movie_name, updatedMovie);
		
	}

}
