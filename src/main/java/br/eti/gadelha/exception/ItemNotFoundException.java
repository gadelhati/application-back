package br.eti.gadelha.exception;

/**
 * By: Nullbeans.com
 * Exception thrown when the requested item is not found.
 */
public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(){
        super();
    }

    public ItemNotFoundException(String message){
        super(message);
    }

}