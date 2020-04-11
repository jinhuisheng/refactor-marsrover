package com.example.demo.controller;

import com.example.demo.Application;
import com.example.demo.domain.Homework;
import com.example.demo.domain.HomeworkRepository;
import com.example.demo.fixture.JsonMatchers;
import com.example.demo.fixture.JsonRequestBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author huisheng.jin
 * @date 2020/4/8.
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class HomeworkControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    HomeworkRepository homeworkRepository;

    @Test
    @WithMockUser(value = "student", roles = "STUDENT")
    void 作业保存到数据库() throws Exception {
        SubmitHomeworkCommand submitHomeworkCommand = new SubmitHomeworkCommand("1", "1");
        mvc.perform(JsonRequestBuilders.postJson("/homework", submitHomeworkCommand)).andExpect(status().isOk());
        List<Homework> all = homeworkRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
    }

    @Test
    void 参数为空报错() throws Exception {
        SubmitHomeworkCommand submitHomeworkCommand = new SubmitHomeworkCommand();
        mvc.perform(JsonRequestBuilders.postJson("/homework", submitHomeworkCommand))
                .andExpect(status().isBadRequest());
    }

    @Test
    void 问题参数不为整数报错() throws Exception {
        SubmitHomeworkCommand submitHomeworkCommand = new SubmitHomeworkCommand("fizz", "1");
        mvc.perform(JsonRequestBuilders.postJson("/homework", submitHomeworkCommand))
                .andExpect(status().isBadRequest());
    }

    @Test
    @WithMockUser(value = "student", roles = "STUDENT")
    void 提交作业返回作业结果() throws Exception {
        SubmitHomeworkCommand submitHomeworkCommand = new SubmitHomeworkCommand("1", "1");
        MvcResult mvcResult = mvc.perform(JsonRequestBuilders.postJson("/homework", submitHomeworkCommand))
                .andExpect(status().isOk())
                .andReturn();
        SubmitHomeWorkResult submitHomeWorkResult = JsonMatchers.deserializeBody(SubmitHomeWorkResult.class, mvcResult);

        assertThat(submitHomeWorkResult.getAnswer()).isEqualTo("1");
        assertThat(submitHomeWorkResult.getCorrect()).isEqualTo(true);
    }

}
