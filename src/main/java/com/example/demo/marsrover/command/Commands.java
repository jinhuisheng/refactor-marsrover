package com.example.demo.marsrover;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public class Commands {
    private static HashMap<String, Command> commands = new HashMap<>();

    static {
        commands.put("R", new TurnRightCommand());
        commands.put("L", new TurnLeftCommand());
        commands.put("F", new ForwardCommand());
        commands.put("B", new BackCommand());
    }

    public static Command getCommand(String name) {
        Command command = commands.get(name);
        if (Objects.isNull(command)) {
            throw new IllegalArgumentException();
        }
        return command;
    }
}
