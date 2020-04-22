package com.example.demo.marsrover.command;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public class Commands {

    private static HashMap<String, Command> commands = new HashMap<>();

    static {
        commands.put("L", new TurnLeftCommand());
        commands.put("R", new TurnRightCommand());
        commands.put("F", new ForwardCommand());
        commands.put("B", new BackCommand());
    }

    public static Command getCommand(String command) {
        Command commandExecutor = commands.get(command);
        if (Objects.isNull(commandExecutor)) {
            throw new IllegalArgumentException();
        }
        return commandExecutor;
    }
}
