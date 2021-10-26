package br.eti.gadelha.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author	Marcelo Ribeiro Gadelha
 * @mail	gadelha.ti@gmail.com
 * @link	www.gadelha.eti.br
 **/

@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private int statusCode;
    private String status;
    private String objectName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String description;
    private List<ErrorObject> errors;

    public ErrorResponse(String message, int statusCode, String status, String objectName, List<ErrorObject> errors) {
        this.message = message;
        this.statusCode = statusCode;
        this.status = status;
        this.objectName = objectName;
        this.errors = errors;
    }
    public ErrorResponse(String message, int statusCode, Date timestamp, String description) {
        this.message = message;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
        this.description = description;
    }
}