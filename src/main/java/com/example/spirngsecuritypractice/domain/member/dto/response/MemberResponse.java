package com.example.spirngsecuritypractice.domain.member.dto.response;

import java.util.List;

import lombok.Builder;

@Builder
public record MemberResponse(
        Long id,
        String memberName,
        String password,
        List<String> roles) {

}
