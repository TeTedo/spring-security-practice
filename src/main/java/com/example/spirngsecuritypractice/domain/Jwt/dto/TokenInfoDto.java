package com.example.spirngsecuritypractice.domain.Jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TokenInfoDto {
    // grantType은 jwt 인증 타입
    private String grantType;
    private String accessToken;
    private String refreshToken;
}
