package com.example.spirngsecuritypractice.domain.member.dto.request;

public record MemberSignUpRequestDto(
        String memberName,
        String password) {
}
