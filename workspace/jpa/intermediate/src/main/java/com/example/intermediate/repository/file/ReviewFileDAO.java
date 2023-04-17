package com.example.intermediate.repository.file;

import com.example.intermediate.entity.file.ReviewFile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public class ReviewFileDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //추가
    public ReviewFile save(ReviewFile reviewFile){
        entityManager.persist(reviewFile);
        return reviewFile;
    }

    //조회
    public Optional<ReviewFile> findById(Long id){
        return Optional.ofNullable(entityManager.find(ReviewFile.class, id));
    }

    //전체조회
    public List<ReviewFile> findAll(){
        String query = "select r from ReviewFile r";
        return entityManager.createQuery(query, ReviewFile.class).getResultList();
    }

    //삭제
    public void delete(ReviewFile reviewFile){
        entityManager.remove(reviewFile);
    }
}
