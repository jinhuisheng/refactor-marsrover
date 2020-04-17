package com.example.demo;

import java.util.Arrays;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
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

    public void execute(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(this::executeCommand);
    }

    private void executeCommand(String cmd) {
        Command command = Commands.getCommand(cmd);
        command.execute(this);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void turnLeft() {
        this.direction = direction.getLeft();
    }

    public void turnRight() {
        this.direction = direction.getRight();
    }

    public Direction getDirection() {
        return direction;
    }

    public void moveBack() {
        switch (this.direction) {
            case NORTH:
                this.y -= 1;
                break;
            case SOUTH:
                this.y += 1;
                break;
            case EAST:
                this.x -= 1;
                break;
            case WEST:
                this.x += 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.direction);
        }
    }

    public void moveFront() {
        switch (this.direction) {
            case NORTH:
                this.y += 1;
                break;
            case SOUTH:
                this.y -= 1;
                break;
            case EAST:
                this.x += 1;
                break;
            case WEST:
                this.x -= 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.direction);
        }
    }
}
