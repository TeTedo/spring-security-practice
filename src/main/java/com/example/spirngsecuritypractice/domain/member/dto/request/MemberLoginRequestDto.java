package com.example.spirngsecuritypractice.domain.member.dto.request;

public record MemberLoginRequestDto(
        String memberName,
        String password) {
}
