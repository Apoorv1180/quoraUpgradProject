package com.upgrad.quora.api.exception;

import com.upgrad.quora.api.model.ErrorResponse;
import com.upgrad.quora.service.exception.AuthenticationFailedException;
import com.upgrad.quora.service.exception.SignOutRestrictedException;
import com.upgrad.quora.service.exception.SignUpRestrictedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class RestExceptionHandler {

    /*
     *Exception handler for SignUpRestrictedException
     *HttpStatus: UNPROCESSABLE_ENTITY
     *@Param SignUpRestrictedException, WebRequest
     *@return ResponseEntity<ErrorResponse> with error code and message
     */
    @ExceptionHandler(SignUpRestrictedException.class)
    public ResponseEntity<ErrorResponse> signInRestrictedException(SignUpRestrictedException exp, WebRequest request){
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().code(exp.getCode()).message(exp.getErrorMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
