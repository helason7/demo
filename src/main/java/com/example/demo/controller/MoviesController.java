package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Movies;
import com.example.demo.repository.MoviesRepository;


@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(value = "/api/v1/")
public class MoviesController {

	@Autowired
	private MoviesRepository moviesRepository;
	
	@GetMapping("/Movies")
	public List<Movies> getAllMovies(){
		return moviesRepository.findAll();
	}
	
	@GetMapping("/Movies/{id}")
	public Movies getMovies(@PathVariable Long id){
		Movies movies = moviesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("We dont have The Movie with id: " + id + " "));
		return movies;
	}
	
	@PostMapping("/Movies")
	public Movies createMovies(@RequestBody Movies movies) {
		return moviesRepository.save(movies);
	}
	
	@PostMapping("/Movies/{id}")
	public ResponseEntity<Movies> updateMovies(@PathVariable Long id, @RequestBody Movies moviesDetail) {
		Movies movies = moviesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("We dont have The Movie with id: " + id + " "));
		movies.setTitle(moviesDetail.getTitle());
		movies.setDirector(moviesDetail.getDirector());
		movies.setDescription(moviesDetail.getDescription());
		movies.setGenres(moviesDetail.getGenres());
		movies.setImage(moviesDetail.getImage());
		movies.setRating(moviesDetail.getRating());
		movies.setCreated_at(moviesDetail.getCreated_at());
		movies.setUpdated_at(moviesDetail.getUpdated_at());
		
		Movies updateMovies = moviesRepository.save(movies);
		
		return ResponseEntity.ok(updateMovies);
	}
	
	@DeleteMapping("/Movies/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteMovies(@PathVariable Long id) {
		Movies movies = moviesRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("We dont have The Movie with id: " + id + " "));
		
		moviesRepository.delete(movies);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	
}
