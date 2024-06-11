package br.com.alura.forum.domain;

public class ValidationsException extends RuntimeException {
    public ValidationsException(String message) {
        super(message);
    }
}
