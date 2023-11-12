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
import com.example.demo.model.Genres;
import com.example.demo.repository.GenresRepository;
import com.example.demo.repository.MoviesRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(value = "api/v2")
public class GenresController {

	@Autowired
	private GenresRepository genresRepository;
	
	@GetMapping("/genres")
	public List<Genres> getAllGenres(){
		return genresRepository.findAll();
	}
	
	@PostMapping("/genres")
	public Genres addGenres(@RequestBody Genres genre) {
		return genresRepository.save(genre);
	}
	
	@DeleteMapping("/genres/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteGenres(@PathVariable Long id){
		Genres genres = genresRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found" + id));
		
		genresRepository.delete(genres);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}

}
