package com.fmr.java8.case_study.controller;

import com.fmr.java8.case_study.model.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionTranslator {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionTranslator.class);

    @ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public AppResponse handleConversion(final RuntimeException ex) {
        return new AppResponse(ex.getMessage());
    }

//    @ExceptionHandler(Inv.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<String> handleBookNotFound(RuntimeException ex) {
//        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public AppResponse processValidationError(final Exception ex) {
        logger.error("Error occured during processing and error is ", ex);
        final Map<String, String> errors = new HashMap<String, String>();
        if (ex instanceof MethodArgumentNotValidException) {
            ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors().forEach(error -> {
                errors.put(((FieldError) error).getField(), error.getDefaultMessage());
            });
        } else if (ex instanceof ConstraintViolationException) {
            ((ConstraintViolationException) ex).getConstraintViolations().forEach(error -> {
                errors.put(error.getPropertyPath().toString(), error.getMessage());
            });
        }

        AppResponse app = new AppResponse(errors);

        app.setMessage("Error Occured");
        app.setErrors(ex.getMessage());

        return app;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public AppResponse processRuntimeException(final Exception ex) {
        logger.error("Error occured during processing and error is ", ex);
        return new AppResponse(ex.getMessage());
    }
}
