package com.example.basic.domain.entity;

import com.example.basic.type.FlowerType;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name = "TBL_FLOWER")
public class Flower {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    private int price;
    @Enumerated(EnumType.STRING)
    private FlowerType type;

}