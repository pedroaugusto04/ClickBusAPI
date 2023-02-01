/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pedro.clickbus.api.exceptionhandler;

import com.pedro.clickbus.domain.service.exception.AlreadyRegisteredException;
import com.pedro.clickbus.domain.service.exception.NameNotFoundException;
import com.pedro.clickbus.domain.service.exception.SlugNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author pedro
 */
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private MessageSource messageSource;

    public ExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<Field> fields = new ArrayList<>();
        for (ObjectError objectError : ex.getBindingResult().getAllErrors()) {
            String name = ((FieldError) objectError).getField();
            String message = messageSource.getMessage(objectError, LocaleContextHolder.getLocale());
            fields.add(new Field(name, message));
        }
        Error error = new Error();
        error.setStatus(status.value());
        error.setDescription("Invalid field(s)");
        error.setFields(fields);
        return handleExceptionInternal(ex, error, headers, status, request);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SlugNotFoundException.class)
    public ResponseEntity<Object> handleSlugNotFound(SlugNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Error error = new Error();
        error.setStatus(status.value());
        error.setDescription("Request failed. Slug not found");
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }
    
    
    @org.springframework.web.bind.annotation.ExceptionHandler(NameNotFoundException.class)
    public ResponseEntity<Object> handleNameNotFound(NameNotFoundException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Error error = new Error();
        error.setStatus(status.value());
        error.setDescription("Request failed. Name not found");
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }
    
    @org.springframework.web.bind.annotation.ExceptionHandler(AlreadyRegisteredException.class)
    public ResponseEntity<Object> handleAlreadyRegistered(AlreadyRegisteredException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Error error = new Error();
        error.setStatus(status.value());
        error.setDescription("Request failed. Place already registered");
        return handleExceptionInternal(ex, error, new HttpHeaders(), status, request);
    }
}
