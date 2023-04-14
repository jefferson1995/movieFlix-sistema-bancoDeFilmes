package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class UserService implements UserDetailsService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class); // Para pegar os logs da aplicação

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private AuthService authService;
	
	
	@Transactional(readOnly = true)
	public UserDTO findByUsserLogged() {
		Long id = authService.authenticated().getId();
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Nenhum id encontrado"));

		return new UserDTO(entity);
	}


	/*
	 *  Método do UserDetails para encontrar o e-mail
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.findByEmail(username);
		
		/*
		 *  Caso não encontre o e-mail do usuário, estoura uma exceção
		 */
		if (user == null) {
			logger.error("Usuário não encontrado: " + username);
			throw new UsernameNotFoundException("E-mail não encontrado");
		}
		logger.info("User found: " + username); 
		return user;
	}
}
