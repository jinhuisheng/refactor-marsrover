package com.example.demo.service;

import com.example.demo.domain.Homework;
import com.example.demo.domain.HomeworkRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
 */
@Service
public class Homeworker {
    private final HomeworkRepository homeworkRepository;

    public Homeworker(HomeworkRepository homeworkRepository) {
        this.homeworkRepository = homeworkRepository;
    }

    public HomeworkResult submit(String answer) {
        Integer studentId = getStudentId();
        Boolean result = verifyAnswer(studentId, answer);
        save(answer, studentId, result);
        return new HomeworkResult(answer, result);
    }

    private void save(String answer, Integer studentId, Boolean result) {
        Homework homework = new Homework(studentId, answer, result);
        homeworkRepository.save(homework);
    }

    private Boolean verifyAnswer(Integer studentId, String answer) {
        FizzBuzz fizzBuzz = new FizzBuzz(studentId);
        String result = fizzBuzz.parse();
        return result.equals(answer);
    }

    private Integer getStudentId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return Integer.parseInt(userDetails.getUsername());
    }

}
