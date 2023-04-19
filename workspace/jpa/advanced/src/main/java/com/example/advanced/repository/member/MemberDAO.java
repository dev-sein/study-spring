package com.example.advanced.repository.member;

import com.example.advanced.entity.member.File;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Repository
public class MemberDAO {
    @PersistenceContext
    private EntityManager entityManager;

    //추가
    private File save(File file){
        entityManager.persist(file);
        return file;
    }

    //조회
    private Optional<File> findById(Long id){
//        return Optional.ofNullable(entityManager.find(File.class, 1L));
       String query = "select f from File f join fetch f.member where f.id = :id";
       return Optional.ofNullable(entityManager.createQuery(query, File.class).setParameter("id", id).getSingleResult());
    }

    //전체 조회
    private List<File> findAll(){
        String query = "select f from File f inner join f.member";
        return entityManager.createQuery(query, File.class).getResultList();
    }
}
