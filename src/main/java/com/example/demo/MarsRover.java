package com.example.demo;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public class MarsRover {
    private final Integer x;
    private final Integer y;
    private Direction directionEnum;

    public MarsRover(Integer x, Integer y, Direction directionEnum) {
        this.x = x;
        this.y = y;
        this.directionEnum = directionEnum;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void sendCommands(String commands) {
        if (this.directionEnum == Direction.W) {
            this.directionEnum = Direction.S;
        } else if (this.directionEnum == Direction.S) {
            this.directionEnum = Direction.E;
        } else if (this.directionEnum == Direction.E) {
            this.directionEnum = Direction.N;
        } else if (this.directionEnum == Direction.N) {
            this.directionEnum = Direction.W;
        } else {
            throw new IllegalStateException("Unexpected value: " + this.directionEnum);
        }
    }

    public Direction getDirectionEnum() {
        return this.directionEnum;
    }
}
