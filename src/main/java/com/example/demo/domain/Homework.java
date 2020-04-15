package com.example.demo.domain;

import javax.persistence.*;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
 */

@Entity
@Table(name = "homeworks")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentId;
    private String answer;
    private Boolean success;

    public Homework() {
    }

    public Homework(Integer studentId, String answer, Boolean success) {

        this.studentId = studentId;
        this.answer = answer;
        this.success = success;
    }
}
