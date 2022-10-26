package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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


    @OneToMany(mappedBy = "vendor")
    private List<RFQVendor> rfqVendorList = new ArrayList<>();

    Long rfqQty;

    LocalDate addDate;
    String addUserId;

    LocalDate changeDate;
    String changeUserId;


    // 견적 시간 범위
    LocalDateTime validFrom;
    LocalDateTime validTo;

    public String getRfqNo() {
        return rfqNo;
    }

    public void setRfqNo(String rfqNo) {
        this.rfqNo = rfqNo;
    }

    public String getRfqItemNo() {
        return rfqItemNo;
    }

    public void setRfqItemNo(String rfqItemNo) {
        this.rfqItemNo = rfqItemNo;
    }

    public String getPrNo() {
        return prNo;
    }

    public void setPrNo(String prNo) {
        this.prNo = prNo;
    }

    public String getPrItemNo() {
        return prItemNo;
    }

    public void setPrItemNo(String prItemNo) {
        this.prItemNo = prItemNo;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public Long getRfqQty() {
        return rfqQty;
    }

    public void setRfqQty(Long rfqQty) {
        this.rfqQty = rfqQty;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    public String getAddUserId() {
        return addUserId;
    }

    public void setAddUserId(String addUserId) {
        this.addUserId = addUserId;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }

    public String getChangeUserId() {
        return changeUserId;
    }

    public void setChangeUserId(String changeUserId) {
        this.changeUserId = changeUserId;
    }

    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDateTime validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDateTime getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDateTime validTo) {
        this.validTo = validTo;
    }


}
