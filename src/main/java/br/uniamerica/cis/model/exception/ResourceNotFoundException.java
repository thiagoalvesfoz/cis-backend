package br.uniamerica.cis.model.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super("Recurso não Encontrado. " +  message);
	}
}
