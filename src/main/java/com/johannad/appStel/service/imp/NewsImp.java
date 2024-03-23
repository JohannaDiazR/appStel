package com.johannad.appStel.service.imp;

import com.johannad.appStel.entity.News;
import com.johannad.appStel.repository.NewsRepository;
import com.johannad.appStel.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsImp implements NewsService {

    @Autowired
    private NewsRepository newsRepository;

    private List<News> newsList;

    @Override
    public List<News> findAll()throws Exception {
        this.newsList=this.newsRepository.findAll();
        return this.newsList;
    }
    @Override
    public News findById(int id) {
        News news=this.newsRepository.findById(id);
        return news;
    }
    @Override
    public News create(News news) {
        this.newsRepository.save(news);
        return news;
    }
    @Override
    public void update(News news){
        this.newsRepository.save(news);
    }
    @Override
    public  void delete(News news) {
        this.newsRepository.delete(news);
    }
}
