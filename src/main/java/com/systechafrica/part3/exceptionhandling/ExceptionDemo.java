package com.systechafrica.part3.exceptionhandling;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


public class ExceptionDemo {
    private static final Logger LOGGER =  Logger.getLogger(ExceptionDemo.class.getName());
    static ArticleController articleController = new ArticleController();
    public static void articlesInstances(){
        try {
            Article article = new Article("Introduction to Exception Handling",
                    "An article to teach on exception handling",
                    LocalDate.of(2023, 9, 23),
                    "Exception handling in Java involves...");

            articleController.addArticle(article);
            Article article1 = new Article(
                    "The Art of Code Optimization",
                    "Learn techniques to optimize your code for better performance.",
                    LocalDate.of(2023, 9, 25),
                    "Code optimization is crucial for improving the efficiency of your programs..."
            );
            articleController.addArticle(article1);

            Article article2 = new Article(
                    "Getting Started with Python",
                    "A beginner's guide to Python programming language.",
                    LocalDate.of(2023, 9, 26),
                    "Python is a versatile and beginner-friendly programming language that..."
            );
            articleController.addArticle(article2);

            Article article3 = new Article(
                    "Web Development Trends in 2023",
                    "Stay up-to-date with the latest trends in web development.",
                    LocalDate.of(2023, 9, 27),
                    "As technology evolves, so does the field of web development. In 2023, several..."
            );
            articleController.addArticle(article3);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public static void main(String[] args) {
        try {
            articlesInstances();
            System.out.println("---------------Article By Name ---------------");
            Optional<Article> foundArticle = articleController.findArticleByName("Introduction to Exception Handling");
            System.out.println(foundArticle);
            System.out.println("---------------Article By ID ---------------");

            Optional<Article> articleFoundById = articleController.findArticleById(2);
            System.out.println(articleFoundById);
            System.out.println("---------------All Articles---------------");
            List<Article> articles = articleController.findAllArticles();
            System.out.println(articles);
            articleController.deleteArticleById(20);
            Optional<Article> articleNotFoundById = articleController.findArticleById(90);
            Optional<Article> articleNotFoundByEmail = articleController.findArticleByName("Hello World");

        }catch (Exception ex){
            LOGGER.info("Error Encountered: " + ex.getMessage());
        }

    }
}
