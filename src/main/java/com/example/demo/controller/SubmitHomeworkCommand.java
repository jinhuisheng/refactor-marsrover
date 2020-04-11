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
    @Pattern(regexp = "^[0-9]*$")
    private String question;
    @NotBlank
    private String answer;

    public SubmitHomeworkCommand() {
    }

    public SubmitHomeworkCommand(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
