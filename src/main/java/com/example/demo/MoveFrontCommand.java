package com.example.demo;

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
