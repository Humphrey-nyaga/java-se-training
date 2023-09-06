package com.systechafrica.part2.lms;

public class Book {

    /*Use of default access modifiers (package private), therefore the
     * variables are ony accessible to classes within the same packages as their class*/
    String isbn;
    String title;

    public void printBookDetails(){
        System.out.println("Book Details: " + "Title: " + title  + " " + "ISBN: " +isbn);
    }

}
