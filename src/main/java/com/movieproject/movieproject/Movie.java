package com.movieproject.movieproject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Movies")
public class Movie {
	@Id
	private String movieName;
	private String description;
	private String posterurl;
	
	public Movie(String movieName, String description, String posterurl) {
		super();
		this.movieName = movieName;
		this.description = description;
		this.posterurl = posterurl;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPosterurl() {
		return posterurl;
	}
	public void setPosterurl(String posterurl) {
		this.posterurl = posterurl;
	}
	

}
