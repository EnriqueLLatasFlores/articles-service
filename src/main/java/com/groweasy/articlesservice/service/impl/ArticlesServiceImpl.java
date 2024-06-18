package com.groweasy.articlesservice.service.impl;

import com.groweasy.articlesservice.model.Article;
import com.groweasy.articlesservice.repository.ArticlesRepository;
import com.groweasy.articlesservice.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticlesServiceImpl implements ArticlesService {
    @Autowired
    private ArticlesRepository articlesRepository;

    @Override
    public Article createArticle(Article article) {
        return articlesRepository.save(article);
    }

    @Override
    public Article getArticleById(Long id) {
        return articlesRepository.findById(id).orElse(null);
    }

    @Override
    public Article updateArticle(Long id, Article article) {
        Article articleToUpdate = articlesRepository.findById(id).orElse(null);
        if(null == articleToUpdate){
            return null;
        }
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setLink(article.getLink());
        articleToUpdate.setImage(article.getImage());
        return articlesRepository.save(articleToUpdate);
    }
}
