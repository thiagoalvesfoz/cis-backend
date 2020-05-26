package br.uniamerica.cis.controller.exceptionhandler;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class ResponseApi {
	
	private Integer statusHttp;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;
	private String title;
	private String path;
	private List<Field> fields;
	
	public ResponseApi(Integer statusHttp, Instant timestamp, String title, String path) {
		this.statusHttp = statusHttp;
		this.timestamp = timestamp;
		this.title = title;
		this.path = path;
	}

	@Getter @Setter
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Field {		
		private String name;
		private String message;		
	}
}
