package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.TextUtils;

import com.example.demo.Movie;
import com.example.demo.Song;

@Controller
public class MyController {

	
	@GetMapping("/home")
	public String sayHelloSp(Model model) {
		
		model.addAttribute("name", "Andrea");
		
		return "index";
	}
	
	@GetMapping("/movies")
	public String moviesView(Model model) {
		
		List<Movie> movies = getBestMovies();

		model.addAttribute("movies", movies);
		
		return "movies";
	}
	
	@GetMapping("/songs")
	public String songsView(Model model) {
		
		List<Song> songs = getBestSongs();
		
		model.addAttribute("songs", songs);
		
		return "songs";
	}
	
	@GetMapping("/movies/{id}")
	public String singleMovieView(Model model,
			@PathVariable("id") int id) {
		
		Movie movie = getMovieById(id);
		if (movie != null) 
			model.addAttribute("movie", movie);
		
		return "movie";
	}
	
	@GetMapping("/songs/{id}")
	public String singleSongView(Model model,
			@PathVariable("id") int id) {
		
		Song song = getSongById(id);
		if (song != null) 
			model.addAttribute("song", song);
		
		return "song";
	}
	
	private Movie getMovieById(int id) {
		
		Movie movie = null;
		for (Movie m : getBestMovies()) {
			if (m.getId() == id) {
				movie = m;
			}	
		}
		
		return movie;
	}
	
	private Song getSongById(int id) {
		
		Song song = null;
		for (Song s : getBestSongs()) {
			if (s.getId() == id) {
				song = s;
			}	
		}
		
		return song;
	}
	
	private List<Movie> getBestMovies() {
		
		List<Movie> movies = new ArrayList<Movie>();
		
		Movie movie1 = new Movie(1, "C'era una volta ad HollyWood");
		Movie movie2 = new Movie(2, "Bastardi senza gloria");
		Movie movie3 = new Movie(3, "Apollo 11");
		
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);

		return movies;
	}
	
	private List<Song> getBestSongs() {
		
		List<Song> songs = new ArrayList<Song>();
		
		Song song1 = new Song(1, "Sunday Morning Stroll");
		Song song2 = new Song(2, "Midnight Serenade");
		Song song3 = new Song(3, "Summer Breeze Dance");
		
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		
		return songs;
	}
	
}


