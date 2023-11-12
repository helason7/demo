package com.example.demo.model;

import jakarta.persistence.*;

@Entity()
@Table(name = "genres")
public class Genres {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "genre")
	private String genre;
	
	@Column(name = "value")
	private String value;
	
	public Genres() {
		
	}
	
	public Genres(String genre) {
		super();
		this.genre = genre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
