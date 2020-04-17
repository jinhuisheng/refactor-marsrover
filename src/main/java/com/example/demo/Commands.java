package com.example.demo;

import java.util.HashMap;

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

    public static Command getCommand(String command) {
        return commands.get(command);
    }
}
