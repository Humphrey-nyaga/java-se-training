package com.systechafrica.part3.exceptionhandling;

import java.time.LocalDate;

public class Article {
    private int id;
    private String name;
    private String description;
    private LocalDate datePublished;
    private String content;
   // private  int authorID;

    public Article(String name, String description, LocalDate datePublished, String content) {
        this.name = name;
        this.description = description;
        this.datePublished = datePublished;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article[" + "\n" +
                "ID=" + id + "\n" +
                "Name='" + name + '\'' + "\n" +
                "Description='" + description + '\'' +"\n" +
                "DatePublished=" + datePublished + "\n" +
                "Content='" + content + '\'' + "\n" +
                ']';
    }
}
