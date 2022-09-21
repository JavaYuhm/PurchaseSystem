package com.example.pucrhase.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String loginId;
    String password;
    String name;

    // 멤버 구분 ( 협력업체 / 내부 임직원 / 관리자 )
    String memberType;

    String status;
    LocalDateTime regDate;
    LocalDateTime modDate;
}
