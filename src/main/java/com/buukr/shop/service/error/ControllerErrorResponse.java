package com.buukr.shop.service.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@SuppressWarnings("serial")
@ControllerAdvice
@Component
public class ControllerErrorResponse {

	//private static final long serialVersionUID = 1L;
	
	@Autowired
	ErrorResponse error ;

	@ExceptionHandler(ErrorResponse.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ErrorResponse ex) {
		error.setErrorCode(ex.getErrorCode());
	
		switch(ex.getErrorCode()) {
			case 1000 : error.setMessage (ex.getErrorCode() + " - Shop Couldn't saved : " + ex.getMessage()); break;
			case 1001 : error.setMessage (ex.getErrorCode() + " - Uri Couldn't generated : " + ex.getMessage()); break;
			case 1002 : error.setMessage (ex.getErrorCode() + " - Response Entity Couldn't generated : " + ex.getMessage()); break;
			default   : error.setMessage (ex.getErrorCode() + " - Unknown error occured." + ex.getMessage());
		}
		return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
	}
	
	
	public ErrorResponse getError() {
		return error;
	}

	public void setError(ErrorResponse error) {
		this.error = error;
	}

}
