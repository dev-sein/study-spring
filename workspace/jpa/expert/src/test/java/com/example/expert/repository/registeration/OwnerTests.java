package com.example.expert.repository.registeration;

import com.example.expert.Type.CarBrand;
import com.example.expert.entity.registeration.Car;
import com.example.expert.entity.registeration.Owner;
import com.example.expert.entity.registeration.OwnerAddress;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDate;

@SpringBootTest
@Transactional
@Rollback(false)
@Slf4j
public class OwnerTests {

    @Autowired
    private OwnerDAO ownerDAO;

    @Test
    public void saveTest(){
        Owner owner = new Owner();
        Car car = new Car();
        OwnerAddress ownerAddress = new OwnerAddress();

        owner.setName("정세인");
        owner.setAge(13L);

        car.setName("차이름");
        car.setCarBrand(CarBrand.HYUNDAI);
        car.setPrice(30000L);
        car.setRealeaseDate(LocalDate.of(2023,04,21));
        car.setOwner(owner);
        ownerAddress.setAddress("주소");
        ownerAddress.setAddressDetail("상세주소");
        ownerAddress.setZipcode("우편번호");
    }

}
