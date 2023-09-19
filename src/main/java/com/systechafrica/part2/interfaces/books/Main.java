package com.systechafrica.part2.interfaces.books;

public class Main {
    public static void main(String[] args) {
        BookControllerImpl bookControllerImpl = new BookControllerImpl();
        Book book1 = new Book("978-0345342966", "The Hobbit", "J.R.R. Tolkien");
        bookControllerImpl.createBook(book1);

        Book book2 = new Book("978-0061120084", "To Kill a Mockingbird", "Harper Lee");
        bookControllerImpl.createBook(book2);

        Book book3 = new Book("978-0451524935", "1984", "George Orwell");
        bookControllerImpl.createBook(book3);

        Book book4 = new Book("978-0140283334", "The Catcher in the Rye", "J.D. Salinger");
        bookControllerImpl.createBook(book4);

        Book book5 = new Book("978-1400030651", "The Kite Runner", "Khaled Hosseini");
        bookControllerImpl.createBook(book5);

        bookControllerImpl.findAllBooks();

    }
}
