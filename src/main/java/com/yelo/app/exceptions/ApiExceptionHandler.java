package com.yelo.app.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import javassist.NotFoundException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestControllerAdvice
public class ApiExceptionHandler extends RuntimeException {

    @ExceptionHandler(value = {NotFoundException.class})
    public ResponseEntity<ErrorDetails> exception(Exception exception, WebRequest request) {
        ErrorDetails details = new ErrorDetails(exception.getLocalizedMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDetails> exception2(HttpMessageNotReadableException exception, WebRequest request) {
        ErrorDetails details = new ErrorDetails("Data Formate Error", request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(value = {InvalidDataException.class})
//    public Map<String, String> onMethodArgumentNotValidException(InvalidDataException ex, WebRequest request) {
//        Map<String,String> errors = new HashMap<>();
//       ex.getResult().getAllErrors().forEach((error) -> {
//	        String fieldName = ((FieldError) error).getField();
//	        String errorMessage = error.getDefaultMessage();
//	        errors.put(fieldName, errorMessage);
//	    });
//	    return errors;
//    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorDetails> exception3(Exception exception, WebRequest request) {
        ErrorDetails details = new ErrorDetails(exception.getLocalizedMessage(), request.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

}
