package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

//Classe para identificar o usuário que está autenticado

@Service
public class AuthService {

	@Autowired
	private UserRepository repository;

	@Transactional(readOnly = true)
	public User authenticated() {
		try {
			// Identifica o usuário o nome do usuário que já foi reconhecido pelo spring
			// security
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			return repository.findByEmail(username);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid User"); // Caso ocorre qualquer erro
		}

	}
	
	//Verifica se o user é ROLE_MEMBER ou o mesmo que está logado, se não for admin lançar exceção
	public void validateSelfOrAdmin(Long userId) {
		User user = authenticated();
		//Verifica se o usuário não é ele mesmo e se não é admin
		if((user.getId()!= userId) && !user.hasHole("ROLE_MEMBER")) {
			throw new ForbiddenException("Acess danied");
		}
	}
}