package br.com.otavio.restwithspringbootandjavaerudio.exceptions;

public class MathValidationException extends RuntimeException{
    public MathValidationException(String message){
        super(message);
    }

}
