package br.uniamerica.cis.domain.exception;

public class BusinessRuleException extends RuntimeException {

	private static final long serialVersionUID = 1L; 
	
	public BusinessRuleException(String message) {
		super(message);
	}

}
