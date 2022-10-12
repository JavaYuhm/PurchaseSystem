package com.example.pucrhase.controller;

import com.example.pucrhase.dto.MemberDto;
import com.example.pucrhase.repository.MemberRepository;
import com.example.pucrhase.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public String login(MemberDto memberDto){
        memberService.login(memberDto);
        return "login";
    }
}
