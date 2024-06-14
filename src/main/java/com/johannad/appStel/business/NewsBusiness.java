package com.johannad.appStel.business;

import com.johannad.appStel.dtos.NewsDto;
import com.johannad.appStel.dtos.RoleDto;
import com.johannad.appStel.dtos.WalletStatusDto;
import com.johannad.appStel.entity.News;
import com.johannad.appStel.entity.Role;
import com.johannad.appStel.entity.WalletStatus;
import com.johannad.appStel.service.NewsService;
import com.johannad.appStel.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NewsBusiness {
    @Autowired
    private NewsService newsService;
    @Autowired
    private RoleService roleService;
    private List<News> newsList;

    public List<NewsDto> findAll() throws Exception {
        this.newsList = this.newsService.findAll();
        List<NewsDto> newsDtoList = new ArrayList<>();
        this.newsList.forEach(news -> {
            NewsDto newsDto = new NewsDto();
            newsDto.setId(news.getId());

            Role role = news.getRole();
            if (role != null) {
                RoleDto roleDto = new RoleDto();
                roleDto.setId(role.getId());
                roleDto.setNombreRol(role.getNombreRol());
                newsDto.setRole(roleDto);
            }
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
        news.setRemNovedades(newsDto.getRemNovedades());
        news.setTipoNovedad(newsDto.getTipoNovedad());
        news.setAsuntoNovedades(newsDto.getAsuntoNovedades());
        news.setDescNovedades(newsDto.getDescNovedades());
        news.setEstNovedades(newsDto.getEstNovedades());
        news.setFecNovedades(newsDto.getFecNovedades());
        news.setResNovedades(newsDto.getResNovedades());


        RoleDto roleDto = newsDto.getRole();
        if (roleDto != null) {
            Role role = roleService.findById(roleDto.getId());
            if (role == null) {
                throw new Exception("Role not found");
            }
            news.setRole(role);
        }

        News createdNews = newsService.create(news);
        NewsDto createdNewsDto = new NewsDto();
        createdNewsDto.setId(createdNews.getId());
        createdNewsDto.setRemNovedades(createdNews.getRemNovedades());
        createdNewsDto.setTipoNovedad(createdNews.getTipoNovedad());
        createdNewsDto.setAsuntoNovedades(createdNews.getAsuntoNovedades());
        createdNewsDto.setDescNovedades(createdNews.getDescNovedades());
        createdNewsDto.setEstNovedades(createdNews.getEstNovedades());
        createdNewsDto.setFecNovedades(createdNews.getFecNovedades());
        createdNewsDto.setResNovedades(createdNews.getResNovedades());


        Role role = createdNews.getRole();
        if (role != null) {
            RoleDto createdRoleDto = new RoleDto();
            createdRoleDto.setId(role.getId());
            createdRoleDto.setNombreRol(role.getNombreRol());
            createdNewsDto.setRole(createdRoleDto);
        }

        return createdNewsDto;
    }

    // PUT
    public void update(NewsDto newsDto, int id) throws Exception {
        News existingNews = newsService.findById(id);
        if (existingNews == null) {
            throw new Exception("News not found");
        }
        existingNews.setRemNovedades(newsDto.getRemNovedades());
        existingNews.setTipoNovedad(newsDto.getTipoNovedad());
        existingNews.setAsuntoNovedades(newsDto.getAsuntoNovedades());
        existingNews.setDescNovedades(newsDto.getDescNovedades());
        existingNews.setEstNovedades(newsDto.getEstNovedades());
        existingNews.setFecNovedades(newsDto.getFecNovedades());
        existingNews.setResNovedades(newsDto.getResNovedades());


        RoleDto roleDto = newsDto.getRole();
        if (roleDto != null) {
            Role role = roleService.findById(roleDto.getId());
            if (role == null) {
                throw new Exception("Role not found");
            }
            existingNews.setRole(role);
        }

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