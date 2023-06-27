package com.example.spirngsecuritypractice.domain.Jwt.service;

import org.springframework.stereotype.Service;

import com.example.spirngsecuritypractice.domain.Jwt.dto.TokenInfoDto;

@Service
public class JwtService {

    public TokenInfoDto checkToken(String memberName) {

        TokenInfoDto tokenInfoDto = TokenInfoDto.builder().build();

        return tokenInfoDto;
    }
}
