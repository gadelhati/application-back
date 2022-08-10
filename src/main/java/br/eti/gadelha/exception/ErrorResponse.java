//package br.eti.gadelha.exception;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import org.springframework.http.HttpStatus;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Objects;
//
//@AllArgsConstructor @Data
//public class ErrorResponse {
//    private int statusCode;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
//    private Date timestamp;
//    private String message;
//    private String description;
//
//    private String statusName;
//    private Object objectData;
//    private String stackTrace;
//    private List<ErrorObject> errors;
//
//    public void addValidationError(String field, String message){
//        if(Objects.isNull(errors)){
//            errors = new ArrayList<>();
//        }
//        errors.add(new ErrorObject(field, message));
//    }
//    public ErrorResponse(HttpStatus httpStatus, String message, /*String stackTrace, */Object objectData, String description/*, List<ErrorObject> erros*/) {
//        this.timestamp = new Date();
//        this.statusCode = httpStatus.value();
//        this.statusName = httpStatus.name();
//        this.message = message;
////        this.stackTrace = stackTrace;
//        this.objectData = objectData;
//        this.description = description;
//    }
//}