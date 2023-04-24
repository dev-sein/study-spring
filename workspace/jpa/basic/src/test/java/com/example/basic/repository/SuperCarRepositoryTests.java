package com.example.basic.repository;

import com.example.basic.domain.entity.SuperCar;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.basic.type.SuperCarType.FERRARI;
import static com.example.basic.type.SuperCarType.LAMBORGHINI;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class SuperCarRepositoryTests {

    @Autowired
    private SuperCarRepository superCarRepository;

    @Test
    public void saveTest(){
        SuperCar superCar1 = SuperCar.builder()
                .name("붕붕이")
                .color("블랙")
                .price(200000.0)
                .type(FERRARI)
                .releaseDate(LocalDateTime.of(2023,04,24,00,00)).build();

        SuperCar superCar2 = SuperCar.builder()
                .name("세인카")
                .color("화이트")
                .price(500000.0)
                .type(FERRARI)
                .releaseDate(LocalDateTime.of(2023,04,27,00,00)).build();

        SuperCar superCar3 = SuperCar.builder()
                .name("세인카2")
                .color("레드")
                .price(500000.0)
                .type(LAMBORGHINI)
                .releaseDate(LocalDateTime.of(2023,05,27,00,00)).build();

        SuperCar superCar4 = SuperCar.builder()
                .name("세인카3")
                .color("블랙")
                .price(700000.0)
                .type(LAMBORGHINI)
                .releaseDate(LocalDateTime.of(2023,05,30,00,00)).build();

        List<SuperCar> superCars = new ArrayList<>(Arrays.asList(superCar1, superCar2, superCar3, superCar4));
        superCarRepository.saveAll(superCars);
    }

    @Test
    public void findByIdTest(){
    superCarRepository.findById(79L).ifPresent(superCar -> log.info(superCar.getName()));
    }

    @Test
    public void findAllTest(){
        assertThat(superCarRepository.findAll()).hasSize(4);
    }

    @Test
    public void findByColorTest(){
        superCarRepository.findByColor("블랙").stream().map(SuperCar::toString).forEach(log::info);
    }

    @Test
    public void findAllOrderByReleaseDateTest(){
        superCarRepository.findAllOrderByReleaseDate()
    }
}
