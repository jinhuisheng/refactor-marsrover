package com.example.demo.controller;

/**
 * @author huisheng.jin
 * @date 2020/4/14.
 */
public class FizzBuzz {
    private Integer number;

    public FizzBuzz(Integer number) {
        this.number = number;
    }

    public String parse() {
        if (isDividedBy(3) && isDividedBy(5)) {
            return "FizzBuzz";
        }
        if (isDividedBy(5) || isContains(5)) {
            return "Buzz";
        }
        if (isDividedBy(3) || isContains(3)) {
            return "Fizz";
        }
        return String.valueOf(number);
    }

    private boolean isContains(int i) {
        return String.valueOf(this.number).contains(String.valueOf(i));
    }

    private boolean isDividedBy(int i) {
        return this.number % i == 0;
    }
}
