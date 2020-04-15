package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author huisheng.jin
 * @date 2020/4/14.
 */
@WebMvcTest(FizzBuzzController.class)
public class FizzBuzzControllerTest {
    @Autowired
    MockMvc mvc;

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,2",
            "3,Fizz",
            "6,Fizz",
            "13,Fizz",
            "5,Buzz",
            "10,Buzz",
            "52,Buzz",
            "15,FizzBuzz",
    })
    void parseAs(Integer number, String expected) throws Exception {
        mvc.perform(get("/fizzbuzz/{number}", number))
                .andExpect(status().isOk())
                .andExpect(content().string(expected));
    }

    @Test
    void N等于0时报400() throws Exception {
        mvc.perform(get("/fizzbuzz/{number}", 0))
                .andExpect(status().isBadRequest());
    }

    @Test
    void N小于0时报400() throws Exception {
        mvc.perform(get("/fizzbuzz/{number}", -1))
                .andExpect(status().isBadRequest());
    }

}
