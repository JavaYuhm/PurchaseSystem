package com.example.pucrhase.domain;

import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    String loginId;
    String password;
    String name;

    // 멤버 구분 ( 협력업체 / 내부 임직원 / 관리자 )
    MemberType memberType;

    String status;
    LocalDateTime regDate;
    LocalDateTime modDate;

    @Builder
    public Member(String loginId, String password, String name, MemberType memberType, LocalDateTime now) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.memberType = memberType;
        this.regDate = now;
    }
    @Builder
    public Member(String loginId, String password, String name, MemberType memberType, String status, LocalDateTime now) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.memberType = memberType;
        this.status = status;
        this.modDate = now;
    }
    public Member() {
    }


    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }

    public LocalDateTime getModDate() {
        return modDate;
    }

}
