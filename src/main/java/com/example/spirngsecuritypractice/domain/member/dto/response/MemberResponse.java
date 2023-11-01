package com.example.spirngsecuritypractice.domain.member.dto.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MemberResponse {
        Long id;
        String memberName;
        String password;
        List<String> roles;
}
