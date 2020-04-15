package com.example.demo.controller;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author huisheng.jin
 * @date 2020/4/8.
 */
public class SubmitHomeworkCommand {
    @NotBlank
    private String answer;

    public SubmitHomeworkCommand() {
    }

    public SubmitHomeworkCommand(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
