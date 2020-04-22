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

    public void sendCommands(String commands) {
        Arrays.stream(commands.split(""))
                .forEach(this::executeCommand);
    }

    private void executeCommand(String command) {
        if (StringUtils.isEmpty(command)) {
            return;
        }
        Command commandExecutor = Commands.getCommand(command);
        commandExecutor.execute(this);
    }

    public void forward() {
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

    public void back() {
        switch (this.direction) {
            case S:
                this.y += 1;
                break;
            case N:
                this.y -= 1;
                break;
            case E:
                this.x -= 1;
                break;
            case W:
                this.x += 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + this.direction);
        }
    }

    public void turnLeft() {
        this.direction = this.direction.left();
    }

    public void turnRight() {
        this.direction = this.direction.right();
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Direction getDirection() {
        return this.direction;
    }
}
