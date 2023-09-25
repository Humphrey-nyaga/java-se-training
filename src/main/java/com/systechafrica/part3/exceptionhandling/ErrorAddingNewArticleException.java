package com.systechafrica.part3.exceptionhandling;

public class ErrorAddingNewArticleException extends RuntimeException {
    public ErrorAddingNewArticleException(String s) {
        super(s);
    }
}
