package com.example.expert.entity.registeration;

import com.example.expert.Type.CarBrand;
import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @ToString(exclude = "owner")
@Table(name = "TBL_CAR")
public class Car {
    @Id @GeneratedValue @EqualsAndHashCode.Include
    private Long id;
    @NotNull @Column(unique = true)
    @Enumerated(EnumType.STRING)
    private CarBrand carBrand;
    @NotNull private String name;
    @NotNull private Long price;
    @NotNull private LocalDate realeaseDate;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    Owner owner = new Owner();
}