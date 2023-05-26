package org.example.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler {

    // handle exception and class description to developer
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<String> manageException(Exception ex) {
        StackTraceElement[] ste = ex.getStackTrace();
        String className=ste[ste.length - 1].getClassName();
        System.out.println(className);

        return new ResponseEntity<>("Exception occur: " + className , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handle data access exception
    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<String> handleDataAccessException(DataAccessException ex) {
        return new ResponseEntity<>("DataAccessException Occur", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}