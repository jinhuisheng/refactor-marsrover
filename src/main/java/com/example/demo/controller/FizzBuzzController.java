package com.example.demo.controller;

import com.example.demo.service.BadRequestException;
import com.example.demo.service.FizzBuzz;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huisheng.jin
 * @date 2020/4/14.
 */
@RestController
@RequestMapping("/fizzbuzz")
public class FizzBuzzController {
    @GetMapping("{number}")
    public String parse(@PathVariable Integer number) {
        if (number <= 0) {
            throw new BadRequestException();
        }
        return new FizzBuzz(number).parse();
    }
}
