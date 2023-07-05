package br.com.otavio.restwithspringbootandjavaerudio.Exceptions;

import lombok.Getter;

import java.util.Date;

@Getter
public class ExceptionResponse {

    private Date timestamp;

    public ExceptionResponse(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    private String message;
    private String details;
}
