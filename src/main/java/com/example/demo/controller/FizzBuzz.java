package com.example.demo.controller;

/**
 * @author huisheng.jin
 * @date 2020/4/9.
 */
public class FizzBuzz {
    private Integer number;

    public FizzBuzz(Integer number) {

        this.number = number;
    }

    public static String of(Integer number) {
        if (number <= 0) {
            throw new BadRequestException();
        }
        FizzBuzz fizzBuzz = new FizzBuzz(number);
        return fizzBuzz.of();
    }

    public String of() {
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
