package com.johannad.appStel.repository;
import com.johannad.appStel.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsRepository extends JpaRepository<News,Integer> {
    @Query(value= "select n From News n where n.id= :id")
    public News findById(int id);
}
