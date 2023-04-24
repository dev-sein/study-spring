package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface SuperCarRepository extends JpaRepository<SuperCar, Long> {
    public List<SuperCar> findByName(String name);
    public List<SuperCar> findByColor(String Color);
//    public List<SuperCar> findByPriceGraterThanEqualOrderByPriceDesc(Double price);
    public List<SuperCar> findAllOrderByReleaseDate(LocalDateTime releaseDate);
    public List<SuperCar> findByNameContaining(String name);
    public boolean existsByColor(String color);
//    public void deleteByPriceGraterThanEqual(Double price);

}
