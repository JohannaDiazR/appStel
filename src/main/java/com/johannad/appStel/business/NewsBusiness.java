package com.johannad.appStel.business;

import com.johannad.appStel.dtos.NewsDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.entity.News;
import com.johannad.appStel.entity.WalletStatus;
import com.johannad.appStel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsBusiness {
    @Autowired
    private NewsService newsService;
    private List<News> newsList;

    public List<NewsDto> findAll() throws Exception {
        this.newsList = this.newsService.findAll();
        List<NewsDto> newsDtoList = new ArrayList<>();
        this.newsList.forEach(news -> {
            NewsDto newsDto = new NewsDto();
            newsDto.setId(news.getId());
            newsDto.setRemNovedades(news.getRemNovedades());
            newsDto.setTipoNovedad(news.getTipoNovedad());
            newsDto.setAsuntoNovedades(news.getAsuntoNovedades());
            newsDto.setDescNovedades(news.getDescNovedades());
            newsDto.setFecNovedades(news.getFecNovedades());
            newsDto.setResNovedades(news.getResNovedades());
            newsDto.setEstNovedades(news.getEstNovedades());
            newsDtoList.add(newsDto);
        });
        return newsDtoList;
    }
    // POST
    public NewsDto create(NewsDto newsDto) throws Exception {
        News news = new News();
        news.setAsuntoNovedades(newsDto.getAsuntoNovedades());
        news.setDescNovedades(newsDto.getDescNovedades());
        news.setEstNovedades(newsDto.getEstNovedades());
        news.setFecNovedades(newsDto.getFecNovedades());
        news.setRemNovedades(newsDto.getRemNovedades());
        news.setResNovedades(newsDto.getResNovedades());
        news.setTipoNovedad(newsDto.getTipoNovedad());

        News createdNews = newsService.create(news);
        NewsDto createdNewsDto = new NewsDto();
        createdNewsDto.setId(createdNews.getId());
        createdNewsDto.setAsuntoNovedades(createdNews.getAsuntoNovedades());
        createdNewsDto.setDescNovedades(createdNews.getDescNovedades());
        createdNewsDto.setEstNovedades(createdNews.getEstNovedades());
        createdNewsDto.setFecNovedades(createdNews.getFecNovedades());
        createdNewsDto.setRemNovedades(createdNews.getRemNovedades());
        createdNewsDto.setResNovedades(createdNews.getResNovedades());
        createdNewsDto.setTipoNovedad(createdNews.getTipoNovedad());

        return createdNewsDto;
    }

    // PUT
    public void update(NewsDto newsDto, int id) throws Exception {
        News existingNews = newsService.findById(id);
        if (existingNews == null) {
            throw new Exception("News not found");
        }

        existingNews.setAsuntoNovedades(newsDto.getAsuntoNovedades());
        existingNews.setDescNovedades(newsDto.getDescNovedades());
        existingNews.setEstNovedades(newsDto.getEstNovedades());
        existingNews.setFecNovedades(newsDto.getFecNovedades());
        existingNews.setRemNovedades(newsDto.getRemNovedades());
        existingNews.setResNovedades(newsDto.getResNovedades());
        existingNews.setTipoNovedad(newsDto.getTipoNovedad());

        newsService.update(existingNews);
    }
    public void delete(int id) throws Exception {
        News existingNews = newsService.findById(id);
        if (existingNews == null) {
            throw new Exception("News not found");
        }

        newsService.delete(existingNews);
    }



}