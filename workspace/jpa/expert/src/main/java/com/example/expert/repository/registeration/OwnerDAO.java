package com.example.expert.repository.registeration;

import com.example.expert.entity.registeration.Car;
import com.example.expert.entity.registeration.Owner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class OwnerDAO {
    @PersistenceContext
    private EntityManager entityManager;

    private Owner save(Owner owner){ entityManager.persist(owner); return owner; }
    private Car saveCar(Car car){entityManager.persist(car); return car;}

    private Optional<Owner> findById(Long id){
//        return Optional.ofNullable(entityManager.find(Owner.class, id));
        String query = "select o from Owner o join fetch o.cars where o.id = :id";
        return Optional.ofNullable(entityManager.
                createQuery(query,Owner.class).
                setParameter("id", id).getSingleResult());
    }

    private Optional<Car> findCarById(Long id){
//        return Optional.ofNullable(entityManager.find(Owner.class, id));
        String query = "select c from Car c join fetch c.owner where c.id = :id";
        return Optional.ofNullable(entityManager.
                createQuery(query,Car.class).
                setParameter("id", id).getSingleResult());
    }

    private List<Owner> findAll(){
        String query = "select o from Owner o join fetch o.cars";
        return entityManager.createQuery(query,Owner.class).getResultList();
    }

    private void delete(Owner owner){entityManager.remove(owner);}
}
