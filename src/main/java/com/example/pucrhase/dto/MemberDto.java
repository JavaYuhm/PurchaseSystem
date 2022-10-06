package com.example.pucrhase.dto;

import com.example.pucrhase.domain.MemberType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MemberDto {

    String loginId;
    String password;
    String name;

    // 멤버 구분 ( 협력업체 / 내부 임직원 / 관리자 )
    MemberType memberType;

    String status;
    LocalDateTime regDate;
    LocalDateTime modDate;
}
