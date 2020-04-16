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

    public HomeworkResult submitHomework(String answer) {
        Integer studentId = getStudentId();
        Boolean success = verifyAnswer(studentId, answer);
        save(answer, studentId, success);
        return new HomeworkResult(answer, success);
    }

    private void save(String answer, Integer studentId, Boolean success) {
        Homework homework = new Homework(studentId, answer, success);
        homeworkRepository.save(homework);
    }

    private Boolean verifyAnswer(Integer studentId, String answer) {
        FizzBuzz fizzBuzz = new FizzBuzz(studentId);
        String result = fizzBuzz.parse();
        return answer.equals(result);
    }

    private Integer getStudentId() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return Integer.valueOf(userDetails.getUsername());
    }

}
