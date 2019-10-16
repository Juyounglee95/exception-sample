package com.skcc.demo.exceptionsample.context.exceptionhandle;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.skcc.demo.exceptionsample.context.exceptionhandle.apierror.ApiErrorDetail;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     *  HttpMessageConverter 에서 등록한 HttpMessageConverter binding 못할경우 발생
     *  주로 @RequestBody, @RequestPart 어노테이션에서 발생
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApiErrorDetail> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        ApiErrorDetail errorDetail = new ApiErrorDetail(HttpStatus.BAD_REQUEST);
		
		errorDetail.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    /**
     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
     * ref https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-ann-modelattrib-method-args
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ApiErrorDetail> handleBindException(BindException e) {
        log.error("handleBindException", e);
        ApiErrorDetail errorDetail = new ApiErrorDetail(HttpStatus.BAD_REQUEST);
		
		errorDetail.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     * 주로 @RequestParam enum으로 binding 못했을 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ApiErrorDetail> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("handleMethodArgumentTypeMismatchException", e);
        ApiErrorDetail errorDetail = new ApiErrorDetail(HttpStatus.BAD_REQUEST);
		
		errorDetail.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ApiErrorDetail> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        ApiErrorDetail errorDetail = new ApiErrorDetail(HttpStatus.BAD_REQUEST);
		
		errorDetail.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ApiErrorDetail> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        ApiErrorDetail errorDetail = new ApiErrorDetail(HttpStatus.BAD_REQUEST);
		
		errorDetail.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.BAD_REQUEST);
    }

    


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiErrorDetail> handleException(Exception e) {
        log.error("handleEntityNotFoundException", e);
        ApiErrorDetail errorDetail = new ApiErrorDetail(HttpStatus.INTERNAL_SERVER_ERROR);
		
		errorDetail.setMessage(e.getMessage());
        return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * View와 연결
     
//	@ExceptionHandler(Exception.class)
//	 	 public ModelAndView handleError(HttpServletRequest req, Exception ex) {
//		log.error("handleEntityNotFoundException", e);
//	    ModelAndView mav = new ModelAndView();
//	    mav.addObject("exception", ex);
//	    mav.addObject("url", req.getRequestURL());
//	    mav.setViewName("error");
//	    return mav;
//	  }
 * 
 * */
 
}