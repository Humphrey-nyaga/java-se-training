package com.systechafrica.part3.exceptionhandling;

import java.time.LocalDate;

public class ExceptionDemo {
    public static void main(String[] args) {
        ArticleController articleController = new ArticleController();
        Article article = new Article("Introduction to Exception Handling",
                "An article to teach on exception handling",
                LocalDate.of(2023,9,23),
                "Exception handling in Java involves" +
                        " managing errors during program execution," +
                        " with try-catch blocks to handle exceptions gracefully, " +
                        "ensuring robust and reliable code.");

        articleController.addArticle(article);
        System.out.println(articleController.findArticleByName("Introduction to Exception Handling"));
    }
}
