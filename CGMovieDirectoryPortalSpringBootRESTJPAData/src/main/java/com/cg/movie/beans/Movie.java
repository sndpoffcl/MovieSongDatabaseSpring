package com.cg.movie.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import com.sun.javafx.collections.MappingChange.Map;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieName;
	private String actorName;
	private String actressName;
	private Date releaseDate;
	@OneToMany(mappedBy="movie")
	@ElementCollection
	private Set< Song> songs ;
	
	
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Movie(String movieName, String actorName, String actressName, Date releaseDate, Set<Song> songs) {
		super();
		this.movieName = movieName;
		this.actorName = actorName;
		this.actressName = actressName;
		this.releaseDate = releaseDate;
		this.songs = songs;
	}


	public Movie(int movieId, String movieName, String actorName, String actressName, Date releaseDate,
			Set< Song> songs) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.actorName = actorName;
		this.actressName = actressName;
		this.releaseDate = releaseDate;
		this.songs = songs;
	}


	public int getMovieId() {
		return movieId;
	}


	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public String getActorName() {
		return actorName;
	}


	public void setActorName(String actorName) {
		this.actorName = actorName;
	}


	public String getActressName() {
		return actressName;
	}


	public void setActressName(String actressName) {
		this.actressName = actressName;
	}


	public Date getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}


	public Set< Song> getSongs() {
		return songs;
	}


	public void setSongs(Set< Song> songs) {
		this.songs = songs;
	}


	
	
	
}
