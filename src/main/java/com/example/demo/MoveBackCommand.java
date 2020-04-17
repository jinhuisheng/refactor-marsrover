package com.example.demo;

/**
 * @author huisheng.jin
 * @date 2020/4/17.
 */
public class MoveBackCommand implements Command {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.moveBack();

    }
}
