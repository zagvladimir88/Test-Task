package com.zagvladimir.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Log4j2
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handlerConstraintViolationException(
            ConstraintViolationException e) {

        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
        Set<String> messages = new HashSet<>(constraintViolations.size());
        messages.addAll(
                constraintViolations.stream()
                        .map(
                                constraintViolation ->
                                        String.format(
                                                "%s value '%s' %s",
                                                constraintViolation.getPropertyPath(),
                                                constraintViolation.getInvalidValue(),
                                                constraintViolation.getMessage()))
                        .collect(Collectors.toList()));
        log.warn("Bad request: {}", messages);
        return new ResponseEntity<>(
                Collections.singletonMap("error", messages), BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

        Map<String, String> messages = new HashMap<>();
        for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
            messages.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        log.warn("Bad request: {}", messages);
        return new ResponseEntity<>(
                Collections.singletonMap("error", messages), HttpStatus.BAD_REQUEST);
    }
}
