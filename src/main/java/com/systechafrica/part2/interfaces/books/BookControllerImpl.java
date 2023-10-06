package com.systechafrica.part2.interfaces.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class BookControllerImpl implements BookController {
    private static final Logger LOGGER = Logger.getLogger(BookControllerImpl.class.getName());
    List<Book> books = new ArrayList<>();
    AtomicInteger seq = new AtomicInteger();

    public int idGenerator() {
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
       return books.stream()
       .filter(book->isbn.equals(book.getIsbn()))
       .findFirst();

    }

    @Override
    public Optional<Book>updateBook(String isbn, String title) {

        Optional<Book> book = findBook(isbn);
        if(book.isPresent()){
            book.get().setTitle(title);
            return book;
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public void deleteBook(String isbn) {
    }

    public void findAllBooks() {
        books.stream().forEach(System.out::print);
    }
}
