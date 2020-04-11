package com.example.demo.controller;

/**
 * @author huisheng.jin
 * @date 2020/4/9.
 */
public class SubmitHomeWorkResult {
    private String answer;
    private Boolean correct;

    public SubmitHomeWorkResult() {
    }

    public SubmitHomeWorkResult(String answer, Boolean correct) {
        this.answer = answer;
        this.correct = correct;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
