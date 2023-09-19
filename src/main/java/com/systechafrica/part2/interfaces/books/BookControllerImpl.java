package com.systechafrica.part2.interfaces.books;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class BookControllerImpl implements BookController{
    List<Book> books = new ArrayList<>();
    AtomicInteger seq = new AtomicInteger();


    public int idGenerator(){
        return seq.incrementAndGet();
    }
    @Override
    public Book createBook(Book book) {
        book.setId(idGenerator());
         books.add(book);
         return book;
    }

    @Override
    public Optional<Book> findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public Book updateBook(String isbn, String title) {
        return null;
    }

    @Override
    public void deleteBook(String isbn) {

    }
    public void findAllBooks(){
        for (Book book :books) {
            System.out.println(book);
        }
    }
}
