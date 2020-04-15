package com.example.demo.controller;

import com.example.demo.service.HomeworkResult;
import com.example.demo.service.Homeworker;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huisheng.jin
 * @date 2020/4/15.
 */
@RestController
@RequestMapping
public class HomeworkController {

    private final Homeworker homeworker;

    public HomeworkController(Homeworker homeworker) {
        this.homeworker = homeworker;
    }

    @PostMapping("/homework/{answer}")
    @PreAuthorize("hasRole('STUDENT')")
    public HomeworkResult submitHomework(@PathVariable String answer) {
        return homeworker.submit(answer);
    }

}
