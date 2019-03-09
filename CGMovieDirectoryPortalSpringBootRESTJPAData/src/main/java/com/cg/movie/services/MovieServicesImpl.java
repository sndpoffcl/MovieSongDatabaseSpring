package com.cg.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.daoServices.MovieDAOServices;
import com.cg.movie.daoServices.SongDAOServices;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.SongNotFoundExceptions;

@Component("movieServices")
public class MovieServicesImpl implements MovieServices {

	@Autowired
	private MovieDAOServices movieDAOServices  ;
	@Autowired
	private SongDAOServices songDAOServices;
	
	@Override
	public Movie acceptMovieDetails(Movie movie) {
		Movie newMovie = movieDAOServices.save(movie);
		return newMovie;
	}

	@Override
	public Song acceptSongDetails(Song song) {
		Song newSong = songDAOServices.save(song);
		return newSong;
	}

	@Override
	public Movie findMovieDetails(int movieId) throws MovieNotFoundException {
		Movie newMovie = movieDAOServices.findById(movieId).orElseThrow(
				()->  new MovieNotFoundException("Movie not found for movieid" + movieId));
		return newMovie;
	}

	@Override
	public Song findSongDetails(int songId) throws SongNotFoundExceptions {
		Song newSong = songDAOServices.findById(songId).orElseThrow(
				()->  new SongNotFoundExceptions("Song not found for movieid" + songId));
		return newSong;
	}

	@Override
	public boolean removeMovieDetails(int movieId) throws MovieNotFoundException {
		Movie deleteMovie = findMovieDetails(movieId);
		movieDAOServices.delete(deleteMovie);
		return true;
	}

	@Override
	public boolean removeSongDetails(int songId) throws SongNotFoundExceptions {
		Song deleteSong = findSongDetails( songId);
		songDAOServices.delete(deleteSong);
		return true;
	}

	@Override
	public List<Movie> findAllMovieDetails() {
		return movieDAOServices.findAll();
	}

	@Override
	public List<Song> findAllSongsOfMovie(int movieId) throws MovieNotFoundException {
		Movie currentMovie = findMovieDetails(movieId);
		return (List<Song>) currentMovie.getSongs();
	}
	
	@Override
	public List<Song> findAllSongsDetails(){
		return songDAOServices.findAll();
	}

}
