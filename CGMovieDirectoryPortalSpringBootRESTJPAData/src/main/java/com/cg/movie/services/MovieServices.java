package com.cg.movie.services;

import java.util.List;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.SongNotFoundExceptions;

public interface MovieServices {
	
	Movie acceptMovieDetails(Movie movie);
	Song acceptSongDetails(Song song);
	Movie findMovieDetails(int movieId) throws MovieNotFoundException;
	Song findSongDetails( int songId) throws SongNotFoundExceptions;
	boolean removeMovieDetails(int movieId) throws MovieNotFoundException;
	boolean removeSongDetails(int songId) throws SongNotFoundExceptions;
	List<Movie> findAllMovieDetails();
	List<Song> findAllSongsOfMovie(int movieId) throws MovieNotFoundException;
	List<Song> findAllSongsDetails();
}
