package com.systechafrica.part3.exceptionhandling;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static com.systechafrica.part3.exceptionhandling.DataStorageClass.articleList;

public class ArticleController {
    AtomicInteger seq = new AtomicInteger();

    public int idGenerator(){
        return seq.incrementAndGet();
    }

    public boolean addArticle(Article article){
        article.setId(idGenerator());
        return articleList.add(article);
    }

    public Optional<Article> findArticleByName(String name){
        return Optional.of(articleList.stream().filter(article->name.equals(article.getName()))
                .findFirst()
                .orElseThrow(()->new ArticleNotFoundException("Article with name " + name + "does not exist")));
    }
    public Optional<Article> findArticleById(int id){
        return Optional.of(articleList.stream().filter(article -> id == article.getId())
                .findFirst()
                .orElseThrow(() -> new ArticleNotFoundException("Article with ID " + id + " not found")));
    }
}
