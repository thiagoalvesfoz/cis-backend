package br.uniamerica.cis.api.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ResponseApi {
	
	private Integer statusHttp;
	private OffsetDateTime dateAndTime;
	private String title;
	private List<Field> fields;
	
	public ResponseApi() {
	}
	
	public ResponseApi(Integer statusHttp, OffsetDateTime dateAndTime, String title) {
		this.statusHttp = statusHttp;
		this.dateAndTime = dateAndTime;
		this.title = title;
	}

	public Integer getStatusHttp() {
		return statusHttp;
	}

	public void setStatusHttp(Integer statusHttp) {
		this.statusHttp = statusHttp;
	}

	public OffsetDateTime getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(OffsetDateTime dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	public static class Field {
		
		private String name;
		private String message;
		
		public Field() {
		}

		public Field(String name, String message) {
			this.name = name;
			this.message = message;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
		
	}
}
