package com.cg.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.movie.beans.Movie;
import com.cg.movie.beans.Song;
import com.cg.movie.exceptions.MovieNotFoundException;
import com.cg.movie.exceptions.SongNotFoundExceptions;
import com.cg.movie.services.MovieServices;

@Controller
public class MovieServicesController {
	
	@Autowired
	MovieServices movieServices;
	
	
	@RequestMapping(value= {"/sayHello"},method=RequestMethod.GET)
	public ResponseEntity<String> sayHello(){
		return new ResponseEntity<String>("Hello World To All From RESTImpl",HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/getMovieDetails"},method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public ResponseEntity<Movie> getMovieDetailsRequestVariable(@RequestParam int movieId) throws MovieNotFoundException{
		Movie movie  = movieServices.findMovieDetails(movieId);
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/getSongDetails"},method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public ResponseEntity<Song> getSongDetailsRequestVariable(@RequestParam int songId) throws MovieNotFoundException, SongNotFoundExceptions{
		Song song  = movieServices.findSongDetails(songId);
		return new ResponseEntity<Song>(song,HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/getAllMovieDetails"},method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public ResponseEntity<List<Movie>> getAllMovieDetailsRequestVariable()  {
		return new ResponseEntity<List<Movie>> (movieServices.findAllMovieDetails(),HttpStatus.OK);
	}
	
	@RequestMapping(value= {"/getAllSongDetails"},method=RequestMethod.GET,
			produces= MediaType.APPLICATION_JSON_VALUE,
			headers = "Accept=application/json")
	public ResponseEntity<List<Song>> getAllSongDetailsRequestVariable()  {
		return new ResponseEntity<List<Song>> (movieServices.findAllSongsDetails(),HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptMovieDetails",method=RequestMethod.POST,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptMovieDetails(@ModelAttribute Movie movie)  {
		 movie = movieServices.acceptMovieDetails(movie);
		return new ResponseEntity<>("Movie details successfully added , movie Id :-" + movie.getMovieId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/acceptSongDetails",method=RequestMethod.POST,
			consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String> acceptSongDetails(@ModelAttribute Song song)  {
		 song = movieServices.acceptSongDetails(song);
		return new ResponseEntity<>("Song details successfully added , song Id :-" + song.getSongId(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteMovieDetails", method=RequestMethod.DELETE)
	public ResponseEntity<String> removeMovieDetails(@RequestParam int movieId) throws MovieNotFoundException  { 
		boolean result = movieServices.removeMovieDetails(movieId);
		return new ResponseEntity<>("Movie details was deleted : " + result ,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteSongDetails", method=RequestMethod.DELETE)
	public ResponseEntity<String> removeSongDetails(@RequestParam int songId) throws SongNotFoundExceptions    { 
		boolean result = movieServices.removeSongDetails(songId);
		return new ResponseEntity<>("Song details was deleted : " + result ,HttpStatus.OK);
	}

}
