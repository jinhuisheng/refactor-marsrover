package com.example.demo.service;

/**
 * @author huisheng.jin
 * @date 2020/4/15.
 */
public class HomeworkResult {
    private String answer;
    private Boolean success;

    public HomeworkResult(String answer, boolean success) {
        this.answer = answer;
        this.success = success;
    }

    public String getAnswer() {
        return answer;
    }

    public Boolean getSuccess() {
        return success;
    }
}
