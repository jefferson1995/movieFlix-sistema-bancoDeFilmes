package com.devsuperior.movieflix.services.exceptions;

/*
 * Classe usada para retornar o erro 403 - Quando o usuário está logado o token é valido
 * mas por regra de negócio não pode acessar o recurso (Perfil não permite)
 */
 
public class ForbiddenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ForbiddenException(String msg) {
		super(msg);
	}

}
