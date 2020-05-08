package br.uniamerica.cis.domain.exception;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Object id) {
		super("Recurso não Encontrado. Id " + id);
	}
}
