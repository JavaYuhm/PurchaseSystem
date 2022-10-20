package com.example.pucrhase.dto;

import com.example.pucrhase.domain.PuchasingRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PrDto {
    String prNo;
    String prItemNo;

    Long itemId;
    String itemNo;
    String itemUnit;
    String itemDescription;

    Double quantity;

    String companyCode;
    String plantCode;
    String prStatus;
    String prType;
    String addUserId;
    String changeUserId;


    LocalDate addDate;
    LocalDate changeDate;

}
