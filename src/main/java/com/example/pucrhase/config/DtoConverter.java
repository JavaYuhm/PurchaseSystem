package com.example.pucrhase.config;

import com.example.pucrhase.domain.Member;
import com.example.pucrhase.domain.PuchasingRequest;
import com.example.pucrhase.dto.MemberDto;
import com.example.pucrhase.dto.PrDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DtoConverter {

    public Member toCreateMember(MemberDto memberDto){
        return new Member(memberDto.getLoginId()
                ,memberDto.getPassword()
                , memberDto.getName()
                , memberDto.getMemberType()
                , LocalDateTime.now());
    }

    public Member toUpdateMember(MemberDto memberDto){
        return new Member(memberDto.getLoginId()
                ,memberDto.getPassword()
                , memberDto.getName()
                , memberDto.getMemberType()
                , memberDto.getStatus()
                , LocalDateTime.now());
    }

}
