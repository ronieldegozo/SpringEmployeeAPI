package com.employee.crud.exception;

import com.employee.crud.dao.EmployeeDAOJpaImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    private static final Logger log = LoggerFactory.getLogger(EmployeeDAOJpaImp.class);

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException ex){

        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
//        log.info("Not Found Exceptions: {}", error.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

//    Handle all exception
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception ex){

        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStackTrace(ex.getStackTrace());
//        log.info("Exceptions: {}", error.getStatus());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}
