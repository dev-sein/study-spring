package com.example.basic.domain.entity;

import com.example.basic.type.Category;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@Table(name = "TBL_BOARD")
public class Board {
    @Id
    @GeneratedValue
    private Long id;
    private String writer;
    @Enumerated(EnumType.STRING)
    private Category cate;
    @Column(nullable = false)
    private String title;
    private String content;
    private LocalDateTime boardDate;
}

