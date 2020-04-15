package com.example.demo.domain;

import javax.persistence.*;

/**
 * @author huisheng.jin
 * @date 2020/4/8.
 */
@Entity
@Table(name = "homeworks")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentId;
    private String question;
    private String answer;
    private Integer correct;

    public Homework(String studentId, String question, String answer, Boolean correct) {
        this.studentId = Integer.parseInt(studentId);
        this.question = question;
        this.answer = answer;
        this.correct = correct ? 1 : 0;
    }

    public Homework() {
    }
}
