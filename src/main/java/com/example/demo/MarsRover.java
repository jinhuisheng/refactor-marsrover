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

    public MarsRover(Integer x, Integer y, Direction value) {

        this.x = x;
        this.y = y;
        this.direction = value;
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

    public void execute(String commands) {
        Arrays.stream(commands.split("")).forEach(cmd -> {
            if (cmd.equals("R")) {
                turnRight();
            } else if (cmd.equals("L")) {
                turnLeft();
            } else if (cmd.equals("F")) {
                moveFront();
            }
        });
    }

    public void moveFront() {
        if (this.direction == Direction.NORTH) {
            this.y += 1;
        } else if (this.direction == Direction.SOUTH) {
            this.y -= 1;
        } else if (this.direction == Direction.EAST) {
            this.x += 1;
        } else if (this.direction == Direction.WEST) {
            this.x -= 1;
        }
    }
}
