package com.cg.movie.beans;

import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int songId;
	private String songName;
	private String singerName;
	private String genre;
	private Time songLength;
	@ManyToOne
	private Movie movie;
	
	
	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Song(int songId, String songName, String singerName, String genre, Time songLength, Movie movie) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.singerName = singerName;
		this.genre = genre;
		this.songLength = songLength;
		this.movie = movie;
	}


	public int getSongId() {
		return songId;
	}


	public void setSongId(int songId) {
		this.songId = songId;
	}


	public String getSongName() {
		return songName;
	}


	public void setSongName(String songName) {
		this.songName = songName;
	}


	public String getSingerName() {
		return singerName;
	}


	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public Time getSongLength() {
		return songLength;
	}


	public void setSongLength(Time songLength) {
		this.songLength = songLength;
	}


	public Movie getMovie() {
		return movie;
	}


	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	
	
	
}
