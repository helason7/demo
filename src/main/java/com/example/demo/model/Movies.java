package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")

public class Movies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "director")
	private String director;
	
	@Column(name = "summary")
	private String summary;
	
	@Column(name = "genres")
	private String genres;
	
	@Column(name = "image")
	private String image;
	
	public Movies() {
		
	}
	
	public Movies(String title, String director, String summary, String genres, String image) {
		super();
		this.title = title;
		this.director = director;
		this.summary = summary;
		this.genres = genres;
		this.image = image;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
