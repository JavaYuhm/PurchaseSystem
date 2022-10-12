package com.example.pucrhase.service;

import com.example.pucrhase.config.DtoConverter;
import com.example.pucrhase.config.JwtTokenProvider;
import com.example.pucrhase.domain.Member;
import com.example.pucrhase.dto.MemberDto;
import com.example.pucrhase.exception.MemberDuplicateExcption;
import com.example.pucrhase.exception.MemberNotFoundException;
import com.example.pucrhase.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService, UserDetailsService {

    private final MemberRepository memberRepository;
    private final DtoConverter dtoConverter;
    private final JwtTokenProvider jwtTokenProvider;


    public MemberServiceImpl(MemberRepository memberRepository, DtoConverter dtoConverter, JwtTokenProvider jwtTokenProvider) {
        this.memberRepository = memberRepository;
        this.dtoConverter = dtoConverter;
        this.jwtTokenProvider = jwtTokenProvider;
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
    public boolean sendMemberResetPassword(MemberDto memberDto) {
        return false;
    }

    @Override
    public boolean resetMemberPassword(String uuid, String password) {
        return false;
    }

    @Override
    public boolean checkResetPassword(String uuid) {
        return false;
    }

    @Override
    public String login(MemberDto memberDto) {
        Optional<Member> optionalMember = memberRepository.findById(memberDto.getLoginId());
        if(optionalMember.isEmpty()){
            throw new MemberNotFoundException("Login ID 를 찾을 수 없습니다.");
        }
        Member member = optionalMember.get();
        return jwtTokenProvider.createToken(member.getUsername(), member.getMemberType());
    }

    @Override
    public void update(MemberDto memberDto) {
        Optional<Member> findbyIdMember = memberRepository.findById(memberDto.getLoginId());

        if(findbyIdMember.isEmpty()){
            throw new MemberNotFoundException("Login ID 를 찾을 수 없습니다.");
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return memberRepository.findById(username).orElseThrow(()->new MemberNotFoundException("Login ID 를 찾을 수 없습니다."));
    }
}
