package com.devsuperior.movieflix.services;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private AuthService authService;
	
	@Autowired
	private ReviewRepository repository;
	//Adiciona um review na mesma tela
		@Transactional
		public ReviewDTO insert(ReviewDTO dto) {
			
			
			Review entity = new Review();
			entity.setText(dto.getText());
			entity.setMovie(new Movie(dto.getMovieId()));
			entity.setUser(authService.authenticated());
			entity = repository.save(entity);
			
			
			return new ReviewDTO(entity); 
		}
		
}
