package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public class MarsRover {
    private Integer x;
    private Integer y;
    private Direction direction;

    public MarsRover(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void sendCommands(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(this::executeCommand);
    }

    private void executeCommand(String command) {
//        List<Command> commands = new ArrayList<>();
//        initCommands();
//        TurnLeftCommand turnLeftCommand = new TurnLeftCommand(this);
//        turnLeftCommand.execute();
        switch (command) {
            case "L":
                turnLeft();
                break;
            case "R":
                turnRight();
                break;
            case "F":
                forward();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + command);
        }
    }

    private void forward() {
        switch (direction) {
            case S:
                this.y -= 1;
                break;
            case N:
                this.y += 1;
                break;
            case E:
                this.x += 1;
                break;
            case W:
                this.x -= 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }

    private void turnRight() {
        this.direction = this.direction.right();
    }

    private void turnLeft() {
        this.direction = this.direction.left();
    }

    public Direction getDirection() {
        return this.direction;
    }
}
