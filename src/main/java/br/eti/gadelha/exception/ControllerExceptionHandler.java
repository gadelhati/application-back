//package br.eti.gadelha.exception;
//
//import netscape.security.ForbiddenTargetException;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//
//import java.nio.file.AccessDeniedException;
//
//@RestControllerAdvice
//public class ControllerExceptionHandler {
//
////    @ExceptionHandler({ AccessDeniedException.class })
////    @ResponseStatus(value = HttpStatus.FORBIDDEN)
////    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
////        return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
////    }
//    @ExceptionHandler(NoSuchElementFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<Object> handleNoSuchElementFoundException(NoSuchElementFoundException exception, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.NOT_FOUND,
//                exception.getMessage(),
//                null,
//                request.getDescription(false));
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
//    }
////    @ExceptionHandler(ResourceNotFoundException.class)
////    @ResponseStatus(value = HttpStatus.FORBIDDEN)
////    public ResponseEntity<ErrorResponse> resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
////        return new ResponseEntity<>(new ErrorResponse(
////                HttpStatus.FORBIDDEN,
////                exception.getMessage(),
////                null,
////                request.getDescription(false)
////        ), HttpStatus.FORBIDDEN);
////    }
//    @ExceptionHandler(ForbiddenTargetException.class)
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public ErrorResponse resourceForbiddenTargetException(ForbiddenTargetException exception, WebRequest request) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.FORBIDDEN,
//                exception.getMessage(),
//                null,
//                request.getDescription(false));
//        return errorResponse;
//    }
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<ErrorResponse> handleNullPointerExceptions(Exception exception, WebRequest request) {
//        return new ResponseEntity<>(new ErrorResponse(
//                HttpStatus.NOT_FOUND,
//                "exception.getMessage()",
//                null,
//                "request.getDescription(false)"
//        ), HttpStatus.NOT_FOUND);
//    }
////    @ExceptionHandler(Exception.class)
////    public ResponseEntity<ErrorResponse> handleExceptions(Exception exception, WebRequest request) {
////        return new ResponseEntity<>(new ErrorResponse(
////                HttpStatus.INTERNAL_SERVER_ERROR,
////                exception.getMessage(),
////                null,
////                request.getDescription(false)
////        ), HttpStatus.INTERNAL_SERVER_ERROR);
////    }
////    @ExceptionHandler(Exception.class)
////    public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
////        // ... potential custom logic
////        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
////        // converting the stack trace to String
////        StringWriter stringWriter = new StringWriter();
////        PrintWriter printWriter = new PrintWriter(stringWriter);
////        e.printStackTrace(printWriter);
////        String stackTrace = stringWriter.toString();
////        return new ResponseEntity<>(new ErrorResponse(
////                        status,
////                        e.getMessage(),
////                        stackTrace
////                ),
////                status
////        );
////    }
//}