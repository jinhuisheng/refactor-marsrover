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

    @GetMapping("/{number}")
    public String of(@PathVariable Integer number) {
        return new FizzBuzz(number).parse();
    }
}
