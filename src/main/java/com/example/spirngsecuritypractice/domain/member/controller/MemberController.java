package com.example.spirngsecuritypractice.domain.member.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spirngsecuritypractice.domain.Jwt.dto.TokenInfoDto;
import com.example.spirngsecuritypractice.domain.member.dto.request.MemberLoginRequestDto;
import com.example.spirngsecuritypractice.domain.member.dto.request.MemberSignUpRequestDto;
import com.example.spirngsecuritypractice.domain.member.dto.response.MemberResponse;
import com.example.spirngsecuritypractice.domain.member.service.MemberService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<TokenInfoDto> login(
            @RequestBody MemberLoginRequestDto memberLoginRequestDto) {

        String memberName = memberLoginRequestDto.getMemberName();
        String password = memberLoginRequestDto.getPassword();
        TokenInfoDto tokenInfoDto = memberService.login(memberName, password);

        return ResponseEntity.ok().body(tokenInfoDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<MemberResponse> signUp(
            @RequestBody MemberSignUpRequestDto memberSignUpRequestDto) {

        String memberName = memberSignUpRequestDto.getMemberName();
        String password = memberSignUpRequestDto.getPassword();

        MemberResponse memberResponse = memberService.signUp(memberName, password);

        return ResponseEntity.ok().body(memberResponse);
    }

    @PostMapping("/admin/signup")
    public ResponseEntity<MemberResponse> adminSignup(
            @RequestBody MemberSignUpRequestDto memberSignUpRequestDto) {

        String memberName = memberSignUpRequestDto.getMemberName();
        String password = memberSignUpRequestDto.getPassword();

        MemberResponse memberResponse = memberService.adminSignUp(memberName, password);

        return ResponseEntity.ok().body(memberResponse);
    }

    @GetMapping("/test")
    public String test() {
        return "success";
    }

    @GetMapping("/admin")
    public String admin() {
        return "success";
    }

    @GetMapping("/any")
    public String any() {
        return "success";
    }
}
