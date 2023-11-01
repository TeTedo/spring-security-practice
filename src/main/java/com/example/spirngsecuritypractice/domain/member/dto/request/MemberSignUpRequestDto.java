package com.example.spirngsecuritypractice.domain.member.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberSignUpRequestDto {
        String memberName;
        String password;
}
