package com.example.pucrhase.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class PuchasingRequest {


    @Id @GeneratedValue
    private Long prId;

    private String prNo;
    private String prItemNo;

    Long itemId;
    String itemNo;
    String itemUnit;
    String itemDescription;
    private Double quantity;

    private String companyCode;
    private String plantCode;
    private String prStatus;
    private String prType;
    private String addUserId;
    private String changeUserId;


    private LocalDate addDate;
    private LocalDate changeDate;

    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }

    public void setPrItemNo(String prItemNo) {
        this.prItemNo = prItemNo;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setPlantCode(String plantCode) {
        this.plantCode = plantCode;
    }

    public void setPrStatus(String prStatus) {
        this.prStatus = prStatus;
    }

    public void setPrType(String prType) {
        this.prType = prType;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public void setChangeUserId(String changeUserId) {
        this.changeUserId = changeUserId;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }
}
