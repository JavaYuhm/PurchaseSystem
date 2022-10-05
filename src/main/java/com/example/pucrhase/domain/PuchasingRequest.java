package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PuchasingRequest {

    @Id
    Long prId;

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
