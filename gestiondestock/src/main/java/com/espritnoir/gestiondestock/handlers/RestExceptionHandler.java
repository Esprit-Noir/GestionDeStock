package com.espritnoir.gestiondestock.handler;

import com.espritnoir.gestiondestock.exception.EntityNotFoundException;
import com.espritnoir.gestiondestock.exception.InvalidEntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDto> handleException(EntityNotFoundException exception, WebRequest webRequest){
        final HttpStatus notFound = HttpStatus.NOT_FOUND;

        return new ResponseEntity<>(
                ErrorDto.builder()
                        .codes(exception.getErrorCodes())
                        .httpCode(notFound.value())
                        .message(exception.getMessage())
                        .build()
                , notFound);
    }

    @ExceptionHandler(InvalidEntityException.class)
    public ResponseEntity<ErrorDto> handleException(InvalidEntityException exception, WebRequest webRequest){
        final HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(
                ErrorDto.builder()
                        .codes(exception.getErrorCodes())
                        .httpCode(badRequest.value())
                        .message(exception.getMessage())
                        .errors(exception.getErrors())
                        .build()
                , badRequest);
    }
}
