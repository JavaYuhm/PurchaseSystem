package com.example.pucrhase.domain;

import javax.persistence.*;

@Entity
public class RFQVendor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rfqId")
    private RFQ rfq;

    @ManyToOne
    @JoinColumn(name = "loginId")
    private Vendor vendor;
}
