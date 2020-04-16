package com.example.demo.service;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
 */
public class HomeworkResult {
    private final String answer;
    private final boolean success;

    public HomeworkResult(String answer, boolean success) {

        this.answer = answer;
        this.success = success;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isSuccess() {
        return success;
    }
}
