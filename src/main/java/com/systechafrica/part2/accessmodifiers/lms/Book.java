package com.systechafrica.part2.accessmodifiers.lms;

public class Book {

    /*Use of default access modifiers (package private), therefore the
     * variables are ony accessible to classes within the same packages as their class*/
    String isbn;
    String title;

    public void printBookDetails(){
        System.out.println("Book Details: " + "Title: " + title  + " " + "ISBN: " +isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.isbn = "9900000";
        book.title = "java";
        System.out.println(book);
    }
}
