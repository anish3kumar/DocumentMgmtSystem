package com.documentmgmtsystem.exception;

import com.documentmgmtsystem.message.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler {

    @ExceptionHandler(DocumentNotFoundException.class)
    public ResponseEntity<ResponseMessage> DocumentNotFoundException(DocumentNotFoundException documentNotFoundException)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseMessage("Document Not Found"));
    }

}
