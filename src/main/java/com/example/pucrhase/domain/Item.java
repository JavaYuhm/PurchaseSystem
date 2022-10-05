package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Item {
    @Id
    Long itemId;

    String itemNo;

    String itemGroup;
    String description;

    String type;
    String unit;
    Long price;

    String itemStatus;
    LocalDate addDate;
    LocalDate changeDate;
}
