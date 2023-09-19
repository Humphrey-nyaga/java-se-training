package com.systechafrica.part2.interfaces.books;

public class BookNotFoundException extends RuntimeException{
    BookNotFoundException(String msg){
        System.out.println(msg);
    }
}
