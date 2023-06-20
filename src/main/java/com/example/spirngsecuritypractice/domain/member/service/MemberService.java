package com.example.spirngsecuritypractice.domain.member.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spirngsecuritypractice.domain.Jwt.dto.TokenInfoDto;
import com.example.spirngsecuritypractice.domain.Jwt.service.JwtTokenProvider;
import com.example.spirngsecuritypractice.domain.member.dto.response.MemberResponse;
import com.example.spirngsecuritypractice.domain.member.model.Member;
import com.example.spirngsecuritypractice.domain.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public TokenInfoDto login(String memberName, String password) {
        // 1. login id/pw 기반으로 Authentication 객체 생성
        // 이때 authentication은 인증 여부를 확인하는 authenticated 값이 false이다.
        password = passwordEncoder.encode(password);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberName,
                password);

        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 메서드가 실행될때 CustomUserDetailsService에서 만든 loadUserByUsername 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfoDto tokenInfoDto = jwtTokenProvider.generateToken(authentication);

        return tokenInfoDto;
    }

    public MemberResponse signUp(String memberName, String password) {
        password = passwordEncoder.encode(password);
        Member member = Member.builder()
                .username(memberName)
                .password(password)
                .roles(new ArrayList<>(Arrays.asList("USER")))
                .build();
        Member savedMember = memberRepository.save(member);

        return MemberResponse.builder()
                .id(savedMember.getId())
                .memberName(savedMember.getUsername())
                .password(savedMember.getPassword())
                .roles(savedMember.getRoles())
                .build();
    }

    public MemberResponse adminSignUp(String memberName, String password) {
        Member member = Member.builder()
                .username(memberName)
                .password(password)
                .roles(new ArrayList<>(Arrays.asList("ADMIN")))
                .build();
        Member savedMember = memberRepository.save(member);

        return MemberResponse.builder()
                .id(savedMember.getId())
                .memberName(savedMember.getUsername())
                .password(savedMember.getPassword())
                .roles(savedMember.getRoles())
                .build();
    }
}
