package com.example.demo.controller;

import com.example.demo.domain.Homework;
import com.example.demo.domain.HomeworkRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author huisheng.jin
 * @date 2020/4/8.
 */
@RestController
@RequestMapping("/homework")
public class HomeworkController {
    private final HomeworkRepository homeworkRepository;

    public HomeworkController(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    @PostMapping("/{answer}")
    @PreAuthorize("hasRole('STUDENT')")
    public SubmitHomeWorkResult submit(@PathVariable String answer) {
        Boolean correct = verifyAnswer(getStudentId(), answer);
        Homework homework = new Homework(getStudentId(), "fizz-buzz-number", answer, correct);
        homeworkRepository.save(homework);
        return new SubmitHomeWorkResult(answer, correct);
    }

    private String getStudentId() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return principal.getUsername();
    }

    private Boolean verifyAnswer(String question, String answer) {
        String result = FizzBuzz.of(Integer.parseInt(question));
        return answer.equals(result);
    }
}
