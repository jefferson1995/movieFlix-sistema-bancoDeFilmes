package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.HashMap;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String text;
	private Long userId;
	private Long movieId;
	
	HashMap<String, String> user = new HashMap<>();

	

	public ReviewDTO() {
		
	}

	public ReviewDTO(Long id, String text, Long userId, Long movieId) {
		super();
		this.id = id;
		this.text = text;
		this.userId = userId;
		this.movieId = movieId;
	}
	
	public ReviewDTO(Review entity) {
		
		id = entity.getId();
		text = entity.getText();
		userId = entity.getUser().getId();
		movieId = entity.getMovie().getId();
		user.put("id", entity.getUser().getId().toString());
		user.put("name", entity.getUser().getName());
		user.put("email", entity.getUser().getEmail());
		
	}
	
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public HashMap<String, String> getUser() {
		return user;
	}

	public void setUser(HashMap<String, String> user) {
		this.user = user;
	}

	
	
	
	

}
