package com.example.pucrhase.domain;

import javax.persistence.Entity;

@Entity
public class Vendor extends Member{
    /*
        사업자 등록번호
     */
    Long bidNo;

    String ceoName;
    String industryType;
    String businessType;
}
