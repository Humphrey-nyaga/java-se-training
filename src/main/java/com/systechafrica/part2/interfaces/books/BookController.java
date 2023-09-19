package com.systechafrica.part2.interfaces.books;

import java.util.Optional;

public interface BookController {
    Book createBook(Book book) ;
    Optional <Book> findBook(String isbn) ;
    Book updateBook(String isbn,String title) ;
    void deleteBook(String isbn) ;

}
