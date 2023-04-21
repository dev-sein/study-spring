package com.example.expert.entity.registeration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter @ToString
public class OwnerAddress {
    private String zipcode;   //우편번호
    private String address;
    private String addressDetail;
}
