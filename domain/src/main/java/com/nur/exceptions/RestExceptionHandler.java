package com.nur.exceptions;

import com.nur.core.BusinessRuleValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(InvalidDataException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(status, new RuntimeException(ex.getMessage()), ex.metodo);
    }
    @ExceptionHandler
    protected ResponseEntity<ErrorResponse> handleException(BusinessRuleValidationException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return buildResponseEntity(status, new RuntimeException(ex.getMessage()), ex.getClass().getName());
    }
    private ResponseEntity<ErrorResponse> buildResponseEntity(HttpStatus  status, Exception exc, String metodo) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exc.getMessage());
        errorResponse.setStatus(status.value());
        errorResponse.setTimestamp(new Date());
        errorResponse.setMetodo(metodo);
        return new ResponseEntity<>(errorResponse, status);
    }
}
