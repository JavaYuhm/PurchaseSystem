package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Contract {
    @Id
    Long contId;

    String contNo;
    String contTitle;
    String contContent;

    String contManagerId;
    String contManagerName;

    String contVendorId;
    String contVendorName;

    String contPrice;
    String contType;

    LocalDateTime contStartDate;
    LocalDateTime contEndDate;

}
