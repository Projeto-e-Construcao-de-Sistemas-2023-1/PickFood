package br.pickfood.exception;

public class NoContentException extends RuntimeException{

    public NoContentException() {
        super();
    }

    public NoContentException(String objectooId) {
        super(objectooId);
    }
}
