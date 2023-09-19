package com.systechafrica.part2.interfaces.books;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String authorName;

    public Book( String isbn, String title, String authorName) {
        this.isbn = isbn;
        this.title = title;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ID: " + id +
                ", ISBN: '" + isbn + '\'' +
                ", Title: '" + title + '\'' +
                ", Author: '" + authorName + '\'' +
                '}';
    }

}
