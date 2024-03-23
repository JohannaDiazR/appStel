package com.johannad.appStel.service;


import com.johannad.appStel.entity.News;

import java.util.List;

public interface NewsService {
    public List<News> findAll() throws Exception;
    public News findById(int id);
    public News create(News news);
    public void update(News news);
    public void delete(News news);
}