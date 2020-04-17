package com.example.demo.marsrover;

import com.example.demo.marsrover.command.*;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author huisheng.jin
 * @date 2020/4/17.
 */
public class Commands {

    private static HashMap<String, Command> commands;

    static {
        commands = new HashMap<>();
        commands.put("F", new MoveFrontCommand());
        commands.put("B", new MoveBackCommand());
        commands.put("L", new TurnLeftCommand());
        commands.put("R", new TurnRightCommand());
    }

    public static Command getCommand(String commandName) {
        Command command = commands.get(commandName);
        if (Objects.isNull(command)) {
            throw new IllegalArgumentException("非法指令");
        }
        return command;
    }
}
