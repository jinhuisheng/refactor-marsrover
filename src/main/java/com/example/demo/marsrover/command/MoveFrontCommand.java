package com.example.demo.marsrover.command;

import com.example.demo.marsrover.MarsRover;

/**
 * @author huisheng.jin
 * @date 2020/4/17.
 */
public class MoveFrontCommand implements Command {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.moveFront();
    }
}