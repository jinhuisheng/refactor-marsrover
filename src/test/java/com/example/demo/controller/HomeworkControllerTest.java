package com.example.demo.controller;

import com.example.demo.domain.Homework;
import com.example.demo.domain.HomeworkRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class HomeworkControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private HomeworkRepository homeworkRepository;

    @Test
    void 提交作业没有身份时返回403() throws Exception {
        mockMvc.perform(post("/homework/{answer}", "1")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(roles = {"ADMIN"})
    void 提交作业身份不正确时返回403() throws Exception {
        mockMvc.perform(post("/homework/{answer}", "1")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "3", roles = {"STUDENT"})
    void id为3的学生提交作业_答案为Fizz_返回成功() throws Exception {
        mockMvc.perform(post("/homework/{answer}", "Fizz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer").value("Fizz"))
                .andExpect(jsonPath(("$.success")).value(true));
    }

    @Test
    @WithMockUser(username = "3", roles = {"STUDENT"})
    void id为3的学生提交作业_答案为3_返回失败() throws Exception {
        mockMvc.perform(post("/homework/{answer}", "3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer").value("3"))
                .andExpect(jsonPath(("$.success")).value(false));
    }

    @Test
    @WithMockUser(username = "3", roles = {"STUDENT"})
    void id为3的学生提交作业_答案为Fizz_返回成功_并保存数据库() throws Exception {
        mockMvc.perform(post("/homework/{answer}", "Fizz"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.answer").value("Fizz"))
                .andExpect(jsonPath(("$.success")).value(true));

        List<Homework> list = homeworkRepository.findAll();
        assertThat(list.size()).isEqualTo(1);

        Homework homework = list.get(0);
        assertThat(homework.getAnswer()).isEqualTo("Fizz");
        assertThat(homework.getSuccess()).isEqualTo(true);
        assertThat(homework.getStudentId()).isEqualTo(3);
    }

}
