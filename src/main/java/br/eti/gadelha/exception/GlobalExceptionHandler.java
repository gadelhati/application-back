package br.eti.gadelha.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders httpHeaders, HttpStatus httpStatus, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(httpStatus, exception.getStackTrace().toString(), exception.getAllErrors().toString());
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler({ AccessDeniedException.class })
//    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
////        return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.FORBIDDEN, "exception.getStackTrace().toString()", "exception.getAllErrors().toString()");
////        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
//            errorResponse.addValidationError("fieldError.getField()", "fieldError.getDefaultMessage()");
////        }
//        return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
//    }
//    @ExceptionHandler({UnauthorizedRequestException.class})
//    protected ResponseEntity<Object> handleUnauthorizedRequestException(UnauthorizedRequestException e, WebRequest request) {
//        ErrorResource error = new ErrorResource("403", e.getMessage());
//        return new ResponseEntity<Object>(error, HttpStatus.FORBIDDEN);
//    }
//    @ExceptionHandler(ItemNotFoundException.class)
//    protected ResponseEntity<Object> handleEntityNotFound(ItemNotFoundException ex, HttpServletRequest request) {
////        log.debug("A REST API error occurred during web call [{}:{}].", request.getMethod(), request.getRequestURI() ,ex);
//        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "The requested resource was not found.", ex.getMessage());
//        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<Object> handle(Exception exception, HttpServletRequest request, HttpServletResponse response) {
//        if (exception instanceof NullPointerException) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        if (exception instanceof MethodArgumentNotValidException) {
//            ErrorResponse errorResponse = new ErrorResponse(httpStatus, exception.getStackTrace().toString(), exception.getAllErrors().toString());
//            for(FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
//                errorResponse.addValidationError(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//    }
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ResponseEntity<Object> handleAccessDeniedException(Exception e, WebRequest request) {
//        return new ResponseEntity<Object>("Acesso negado!", HttpStatus.FORBIDDEN);
//    }
}