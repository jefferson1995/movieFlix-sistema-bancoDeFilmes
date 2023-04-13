package com.devsuperior.movieflix.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

/*
 * Classe extendida standardError e adicionado uma lista do FieldMessage
 */

public class ValidationError extends StandardError {

	private static final long serialVersionUID = 1L;
	

	private List<FieldMessage> errors = new ArrayList<>();

	/*funcionalidade para criar os getters and setters
	 *  Captura somente o getErrors
	 */
	public List<FieldMessage> getErrors() {
		return errors;
	}
	
	/*
	 * Método com parâmetro nome do campo emensagem
	 * instancia uma nova FieldMessage
	 */
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
	
	
}