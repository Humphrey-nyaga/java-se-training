package com.systechafrica.part3.exceptionhandling;

import java.time.LocalDate;
import java.util.Optional;

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            ArticleController articleController = new ArticleController();
            Article article = new Article("Introduction to Exception Handling",
                    "An article to teach on exception handling",
                    LocalDate.of(2023, 9, 23),
                    "Exception handling in Java involves" +
                            " managing errors during program execution," +
                            " with try-catch blocks to handle exceptions gracefully, " +
                            "ensuring robust and reliable code.");

           // articleController.addArticle(article);
            Optional<Article> foundArticle = articleController.findArticleByName("Introduction to Exception");
            System.out.println(foundArticle);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
