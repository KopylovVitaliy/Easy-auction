package ru.skypro.cweasyauction.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.sql.SQLException;

@RestControllerAdvice
public class ExeptionHandler {
    @ExceptionHandler
    public ResponseEntity<?> handleIOException(IOException ioException) {

        String messange = "лот с данным ID не найден";
        return new ResponseEntity<>(messange, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleSQLException(SQLException sqlException) {
        String messange = "Ошибка сервера";
        return new ResponseEntity<>(messange, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception exception) {
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
