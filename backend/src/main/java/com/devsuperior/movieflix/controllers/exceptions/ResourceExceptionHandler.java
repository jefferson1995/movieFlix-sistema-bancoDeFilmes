package com.devsuperior.movieflix.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.movieflix.services.exceptions.DatabaseException;
import com.devsuperior.movieflix.services.exceptions.ForbiddenException;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

/*Classe utilizada para identificar e tratar os erros.
 * Trata os erros conforme a exceção identificada
 */

@ControllerAdvice  
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class) 
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		//404 - Não encontrado
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now()); 
		err.setStatus(status.value());
		err.setError(" Resource not found"); 
		err.setMessage(e.getMessage()); 
		err.setPath(request.getRequestURI()); 
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DatabaseException.class) 
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request){
		
		//400 - Não consegue processar a solicitação
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardError err = new StandardError();
		err.setTimestamp(Instant.now()); 
		err.setStatus(status.value());      
		err.setError(" Darabase exception"); 
		err.setMessage(e.getMessage());      
		err.setPath(request.getRequestURI()); 
		
		return ResponseEntity.status(status).body(err);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	public ResponseEntity<ValidationError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		//422 - DIZ QUE ALGUMA ENTIDADE NÃO FOI PROCESSADA
		
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; 
		
		ValidationError err = new ValidationError();
		err.setTimestamp(Instant.now()); 
		err.setStatus(status.value());       
		err.setError(" validation exception"); 
		err.setMessage(e.getMessage());       
		err.setPath(request.getRequestURI()); 
		
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			err.addError(f.getField(), f.getDefaultMessage()); 
		}
		
		return ResponseEntity.status(status).body(err);
	}
	
	//Tratamentos customizados
	
		//403
		@ExceptionHandler(ForbiddenException.class) //tipo de exception que vai interroper
		public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request){ //tipo que será retornado OAuthCustomError
			
			OAuthCustomError err = new OAuthCustomError("Forbidden", e.getMessage()); //Objeto da resposta
			
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
		}
		
		//401
		@ExceptionHandler(UnauthorizedException.class) //tipo de exception que vai interroper
		public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request){ //tipo que será retornado OAuthCustomError
			
			OAuthCustomError err = new OAuthCustomError("Forbidden", e.getMessage()); //Objeto da resposta
			
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
		}
}