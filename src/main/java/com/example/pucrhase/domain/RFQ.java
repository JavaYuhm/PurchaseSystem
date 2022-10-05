package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class RFQ {
    @Id
    Long rfqId;

    String rfqNo;
    String rfqItemNo;

    String prNo;
    String prItemNo;

    Long itemId;
    String itemNo;
    String itemUnit;
    String itemDescription;

    Long rfqQty;

    LocalDate addDate;
    String addUserId;

    LocalDate changeDate;
    String changeUserId;

    // 견적 시간 범위
    LocalDateTime validFrom;
    LocalDateTime validTo;

}
