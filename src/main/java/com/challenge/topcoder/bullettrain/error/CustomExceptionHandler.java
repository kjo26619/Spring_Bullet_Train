package com.challenge.topcoder.bullettrain.error;

import com.challenge.topcoder.bullettrain.dto.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<GenericResponse> customHandleNotFound(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse(ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HandlerNotFoundException.class)
    public ResponseEntity<GenericResponse> customHandleHandlerNotFound(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse(ex.getMessage(), null), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<GenericResponse> customHandleResourceNotFound(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse(ex.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<GenericResponse> customHandleIncorrectUrl(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse(ex.getMessage(), null), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(EntityEmptyException.class)
    public ResponseEntity<GenericResponse> customEntityEmpty(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse(ex.getMessage(), null), HttpStatus.OK);
    }

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<GenericResponse> customNumberFormat(Exception ex, WebRequest request) {
        return new ResponseEntity<>(new GenericResponse("Invalid endpoint", null), HttpStatus.METHOD_NOT_ALLOWED);
    }

}
