package com.example.basic.domain.entity;

import com.example.basic.type.SuperCarType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @ToString
@Table(name="TBL_Super_Car")
public class SuperCar {
    @Id @GeneratedValue
    private Long Id;
    @Enumerated(EnumType.STRING)
    private SuperCarType superCarType;
    @Column(nullable = false)
    private String carName;
    private String carColor;
    private Long carPrice;
    @DateTimeFormat(pattern = "yyyy/mm/dd HH:mm:ss")
    private LocalDateTime carReleaseDate;

}
