package com.example.demo.marsrover;

import com.example.demo.marsrover.command.Command;
import com.example.demo.marsrover.command.Commands;
import org.springframework.util.StringUtils;

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


    public void send(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(this::executeCommand);
    }

    private void executeCommand(String name) {
        if (StringUtils.isEmpty(name)) {
            return;
        }
        Command command = Commands.getCommand(name);
        command.execute(this);
    }

    public void forward() {
        if (this.direction == Direction.S) {
            this.y -= 1;
        } else if (this.direction == Direction.N) {
            this.y += 1;
        } else if (this.direction == Direction.E) {
            this.x += 1;
        } else if (this.direction == Direction.W) {
            this.x -= 1;
        }
    }

    public void back() {
        if (this.direction == Direction.S) {
            this.y += 1;
        } else if (this.direction == Direction.N) {
            this.y -= 1;
        } else if (this.direction == Direction.E) {
            this.x -= 1;
        } else if (this.direction == Direction.W) {
            this.x += 1;
        }

    }

    public void turnLeft() {
        this.direction = direction.left();
    }

    public void turnRight() {
        this.direction = direction.right();
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

}
