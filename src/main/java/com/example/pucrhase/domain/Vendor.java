package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "vendor")
    private List<RFQVendor> rfqList = new ArrayList<>();


    public Vendor(String loginId, String password, String name, MemberType memberType, LocalDateTime now) {
        super(loginId, password, name, memberType, now);
    }

    public Vendor() {
        super();
    }
}
