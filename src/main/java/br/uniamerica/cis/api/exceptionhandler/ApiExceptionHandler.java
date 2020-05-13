package br.uniamerica.cis.api.exceptionhandler;

import java.time.Instant;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.uniamerica.cis.domain.exception.BusinessRuleException;
import br.uniamerica.cis.domain.exception.ResourceNotFoundException;

@ControllerAdvice //monitors exceptions launched in the Controller.
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(BusinessRuleException.class)
	public ResponseEntity<Object> handleBusinessError(BusinessRuleException ex, WebRequest request){
		var status = HttpStatus.BAD_REQUEST;
		var path = request.getDescription(false).substring(4); //try to do casting for ServletWebRequest
		var body = new ResponseApi(status.value(), Instant.now(), ex.getMessage(), path);
		return super.handleExceptionInternal(ex, body, new HttpHeaders(), status, request);
		
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resouceNotFound(ResourceNotFoundException ex, 
			HttpServletRequest request){		
		
		var error = "Recurso Não encontrado";
		var status = HttpStatus.NOT_FOUND;
		var path = request.getRequestURI();
		var err = new StandardError(Instant.now(), status.value(), error, ex.getMessage(), path);
		
		return ResponseEntity.status(status).body(err);	
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		var statusHttp = status.value();
		var timestamp = Instant.now();
		var title = "Um ou mais campos estão inválidos. "
				+ "Faça o preenchimento correto e tente novamente";
		var path = request.getDescription(false).substring(4);
		var body = new ResponseApi(statusHttp, timestamp, title, path);
		var fields = new ArrayList<ResponseApi.Field>();
		
		for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
			
			var name = ((FieldError)erro).getField();
			var message = erro.getDefaultMessage();
			
			fields.add(new ResponseApi.Field(name, message));
		}
		
		body.setFields(fields);
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
}
