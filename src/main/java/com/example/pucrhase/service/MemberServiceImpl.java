package com.example.pucrhase.service;

import com.example.pucrhase.config.DtoConverter;
import com.example.pucrhase.domain.Member;
import com.example.pucrhase.dto.MemberDto;
import com.example.pucrhase.exception.MemberDuplicateExcption;
import com.example.pucrhase.exception.MemberNotFoundException;
import com.example.pucrhase.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final DtoConverter dtoConverter;

    public MemberServiceImpl(MemberRepository memberRepository, DtoConverter dtoConverter) {
        this.memberRepository = memberRepository;
        this.dtoConverter = dtoConverter;
    }

    @Override
    public void join(MemberDto memberDto) {
        Optional<Member> findbyIdMember = memberRepository.findById(memberDto.getLoginId());

        if(findbyIdMember.isPresent()){
            throw new MemberDuplicateExcption("Login ID 중복");
        }
        memberRepository.save(dtoConverter.toCreateMember(memberDto));
    }

    @Override
    public void login(MemberDto memberDto) {

    }

    @Override
    public void update(MemberDto memberDto) {
        Optional<Member> findbyIdMember = memberRepository.findById(memberDto.getLoginId());

        if(findbyIdMember.isEmpty()){
            throw new MemberNotFoundException("Login ID 를 찾을 수 없습니다.");
        }

    }
}
