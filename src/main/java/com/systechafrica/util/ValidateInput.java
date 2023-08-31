package com.systechafrica.util;

public class ValidateInput {
    public static final boolean validate(String input){
        if(input != null && !input.isEmpty()) {
            return true;
        }
        return false;
    }
}
