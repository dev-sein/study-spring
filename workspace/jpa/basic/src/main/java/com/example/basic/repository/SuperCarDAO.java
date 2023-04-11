package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class SuperCarDAO {

    @PersistenceContext
    private EntityManager entityManager;

    //등록 조회 삭제 수정

    //등록
    public SuperCar save(SuperCar superCar){
        entityManager.persist(superCar);
        return superCar;
    }

    //삭제
    public SuperCar delete(SuperCar superCar){
        entityManager.remove(superCar);
        return superCar;
    }

    //조회
    public Optional<SuperCar> findById(Long id){
        return Optional.ofNullable(entityManager.find(SuperCar.class, id));
    }

}
