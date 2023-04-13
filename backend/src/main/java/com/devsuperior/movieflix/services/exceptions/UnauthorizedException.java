package com.devsuperior.movieflix.services.exceptions;

////Quando o token não for reconhcido, é retornado o 401
public class UnauthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnauthorizedException(String msg) {
		super(msg);
	}

}
