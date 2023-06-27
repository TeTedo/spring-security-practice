package com.example.spirngsecuritypractice.domain.Jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spirngsecuritypractice.domain.Jwt.dto.TokenInfoDto;
import com.example.spirngsecuritypractice.domain.Jwt.dto.request.CheckTokenRequest;
import com.example.spirngsecuritypractice.domain.Jwt.service.JwtService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final JwtService jwtService;

    @PostMapping("/token")
    public ResponseEntity<TokenInfoDto> checkToken(
            @RequestBody CheckTokenRequest checkTokenRequest) {

        String memberName = checkTokenRequest.memberName();

        TokenInfoDto tokenInfoDto = jwtService.checkToken(memberName);

        return ResponseEntity.ok().body(tokenInfoDto);
    }
}
