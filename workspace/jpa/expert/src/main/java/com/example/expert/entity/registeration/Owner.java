package com.example.expert.entity.registeration;

import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @ToString(exclude = "car")
@Table(name = "TBL_OWNER")
public class Owner {
    @Id @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    @NotNull private String name;
    @NotNull private Long age;
    @Embedded private OwnerAddress ownerAddress;

    @OneToMany(fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    List<Car> cars = new ArrayList<>();
}