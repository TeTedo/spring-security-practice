package com.example.spirngsecuritypractice.domain.member.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(roles = "ADMIN")
    @DisplayName("유저로 /members/admin api 이용 가능")
    public void testAccessWithUserRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/members/admin"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    @DisplayName("로그인을 안한채로 불러온경우 401에러 ")
    public void testAccessWithoutLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/members/any"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }

    @Test
    @WithMockUser(roles = "NONE")
    @DisplayName("로그인은 했지만 권한이 없는경우 403에러")
    public void testAccessWithoutRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/members/test"))
                .andExpect(MockMvcResultMatchers.status().isForbidden());
    }

    @Test
    @WithMockUser(roles = { "USER", "ADMIN" })
    @DisplayName("유저나 어드민 권한으로 /members/test api 이용 가능")
    public void testAccessWithUserAndAdminRole() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/members/test"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
