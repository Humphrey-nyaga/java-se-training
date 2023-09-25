package com.systechafrica.part3.exceptionhandling;

public class NewArticleCannotBeAddedException extends RuntimeException {
    public NewArticleCannotBeAddedException(String s) {
        super(s);
    }
}
