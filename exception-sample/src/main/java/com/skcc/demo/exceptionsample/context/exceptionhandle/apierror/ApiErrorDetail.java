package com.skcc.demo.exceptionsample.context.exceptionhandle.apierror;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Data;

@Data
public class ApiErrorDetail {
	
	
	   private HttpStatus status;
	   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone="Asia/Seoul")
	   private LocalDateTime timestamp;
	   private String message;
	   private String debugMessage;
	   private List<ApiSubError> subErrors;

	   private ApiErrorDetail() {
	       timestamp = LocalDateTime.now();
	   }

	   public ApiErrorDetail(HttpStatus status) {
	       this();
	       this.status = status;
	   }

	   public ApiErrorDetail(HttpStatus status, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = "Unexpected error";
	       this.debugMessage = ex.getLocalizedMessage();
	   }

	   public ApiErrorDetail(HttpStatus status, String message, Throwable ex) {
	       this();
	       this.status = status;
	       this.message = message;
	       this.debugMessage = ex.getLocalizedMessage();
	   }
	}

