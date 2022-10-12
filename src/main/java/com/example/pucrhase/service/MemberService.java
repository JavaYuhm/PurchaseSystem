package com.example.pucrhase.service;

import com.example.pucrhase.domain.Member;
import com.example.pucrhase.dto.MemberDto;

public interface MemberService {

    /**
        회원가입 (내부임직원, 구매담당자 - 내부시스템 계정이 있어 별도의 가입은 필요없지만 현재는 없어 Join 기능 구현)
     */
    public void join(MemberDto memberDto);

    boolean sendMemberResetPassword(MemberDto memberDto);

    boolean resetMemberPassword(String uuid, String password);

    boolean checkResetPassword(String uuid);

    /**
     *  로그인
     */
    public String login(MemberDto memberDto);

    /**
     * 회원정보 변경
     */
    public void update(MemberDto memberDto);
}
