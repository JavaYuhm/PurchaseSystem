package com.example.pucrhase.domain;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Vendor extends Member{
    /*
        사업자 등록번호
     */
    Long bidNo;

    String ceoName;

    /*
    산업군
    */
    String industryType;

    /*
    사업군
    */
    String businessType;

    public Vendor(String loginId, String password, String name, MemberType memberType, LocalDateTime now) {
        super(loginId, password, name, memberType, now);
    }

    public Vendor() {
        super();
    }
}
