package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huisheng.jin
 * @date 2020/4/8.
 */
@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {

    private Integer number;

    @GetMapping("/{number}")
    public String of(@PathVariable Integer number) {
        if (number <= 0) {
            throw new BadRequestException();
        }
        this.number = number;
        if (isDivided(3) && isDivided(5)) {
            return "FizzBuzz";
        }
        if (isDivided(3) || isContains(3)) {
            return "Fizz";
        }
        if (isDivided(5) || isContains(5)) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    private boolean isContains(int i) {
        return String.valueOf(number).contains(String.valueOf(i));
    }

    private boolean isDivided(int i) {
        return this.number % i == 0;
    }
}
