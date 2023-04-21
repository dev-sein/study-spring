package com.example.expert.repository.registeration;

import com.example.expert.entity.registeration.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CarDAO {
    @PersistenceContext
    private EntityManager entityManager;

}
