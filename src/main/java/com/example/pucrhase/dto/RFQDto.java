package com.example.pucrhase.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class RFQDto {
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
