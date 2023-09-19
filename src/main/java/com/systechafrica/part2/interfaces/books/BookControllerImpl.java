package com.systechafrica.part2.interfaces.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class BookControllerImpl implements BookController{
    private static final Logger LOGGER = Logger.getLogger(BookControllerImpl.class.getName());
    List<Book> books = new ArrayList<>();
    AtomicInteger seq = new AtomicInteger();


    public int idGenerator(){
        return seq.incrementAndGet();
    }
    @Override
    public Book createBook(Book book) {
        book.setId(idGenerator());
         books.add(book);
         LOGGER.info("Book added successfully");
         return book;
    }

    @Override
    public Optional<Book> findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                LOGGER.info("Book with ISBN: " + isbn+ " retrieved successfully");
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public Book updateBook(String isbn, String title) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                book.setTitle(title);
                LOGGER.info("Book updated successfully");
                return book;
            }
        }
        return null;
    }

    @Override
    public void deleteBook(String isbn) {
        int index = -1;
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                 index = books.indexOf(book);
                 break;
            }
        }
        books.remove(index);
        LOGGER.info("Book deleted successfully");

    }
    public void findAllBooks(){
        for (Book book :books) {
            System.out.println(book);
        }
    }
}
