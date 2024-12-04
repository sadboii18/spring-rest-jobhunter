package com.project.jobhunter.util.exception;

import java.io.ObjectInputFilter.Status;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<RestReponse<Object>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        BindingResult br = ex.getBindingResult();
        final List<FieldError> fieldError = br.getFieldErrors();

        RestReponse<Object> res = new RestReponse<>();
        res.setStatusCode(HttpStatus.BAD_REQUEST.value());
        res.setError(ex.getBody().getDetail());

        List<String> errors = new ArrayList<>();
        for (FieldError f : fieldError) {
            String x = f.getDefaultMessage();
            errors.add(x);
        }
        res.setMessage(errors.size() > 1 ? errors : errors.get(0));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
