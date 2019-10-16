package com.skcc.demo.exceptionsample.context.exceptionhandle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.skcc.demo.exceptionsample.context.exceptionhandle.apierror.ApiErrorDetail;

import lombok.extern.slf4j.Slf4j;


@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {
	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<ApiErrorDetail> handleUserNotFoundException(UserNotFoundException unfe){
    	log.error("handleUserNotFoundException", unfe);
		ApiErrorDetail errorDetail = new ApiErrorDetail(HttpStatus.NOT_FOUND);
		
		errorDetail.setMessage(unfe.getMessage());
		return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	}
	
}	
