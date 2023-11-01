package com.example.spirngsecuritypractice.domain.member.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberLoginRequestDto {
        String memberName;
        String password;
}
