package com.example.demo.marsrover;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public class TurnRightCommand implements Command {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnRight();
    }
}
