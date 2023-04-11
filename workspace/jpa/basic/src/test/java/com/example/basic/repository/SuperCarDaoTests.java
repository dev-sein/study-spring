package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import com.example.basic.type.SuperCarType;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Slf4j
@Transactional
@Rollback(false)
public class SuperCarDaoTests {

    @Autowired
    SuperCarDAO superCarDAO;

    @Test
    public void saveTest(){
        SuperCar superCar = new SuperCar();
        superCar.setCarName("붕붕이");
        superCar.setCarColor("빨강");
        superCar.setCarPrice(30000L);
        superCar.setSuperCarType(SuperCarType.HYUNDAI);
        LocalDateTime date = LocalDateTime.now();
        superCar.setCarReleaseDate(date);
        superCarDAO.save(superCar);
    }

    @Test
    public void deleteTest(){
        SuperCar superCar = new SuperCar();
        superCar.setCarName("붕붕이");
        superCar.setCarColor("빨강");
        superCar.setCarPrice(30000L);
        superCar.setSuperCarType(SuperCarType.HYUNDAI);

        superCarDAO.save(superCar);
        superCarDAO.delete(superCar);
    }

    @Test
    public void findTest(){
        Optional<SuperCar> optionalSuperCar = superCarDAO.findById(1L);
        SuperCar superCar = optionalSuperCar.orElseGet(SuperCar::new);
        optionalSuperCar.ifPresent(supercar -> assertThat(superCar.getCarName()).isEqualTo("빨강색"));

    }
}
