package com.project.jobhunter.service.exception;

import java.net.http.HttpResponse;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.jobhunter.domain.RestReponse;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(IdInvalidException.class)
    public ResponseEntity<RestReponse<Object>> handleIdInvalidException(IdInvalidException ex) {
        RestReponse<Object> res = new RestReponse<Object>();
        res.setError("IdInvalidException");
        res.setMessage("Id khong hop le");
        res.setStatusCode(HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
