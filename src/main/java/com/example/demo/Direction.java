package com.example.demo;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
 */
public enum Direction {
    EAST("N", "E", "S"), SOUTH("E", "S", "W"), WEST("S", "W", "N"), NORTH("W", "N", "E");

    private String left;
    private String name;
    private String right;

    Direction(String left, String name, String right) {
        this.left = left;
        this.name = name;
        this.right = right;
    }

    public static Direction getValue(String name) {
        for (Direction direction : Direction.values()) {
            if (direction.getName().equals(name)) {
                return direction;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public Direction getLeft() {
        return getValue(left);
    }

    public Direction getRight() {
        return getValue(right);
    }
}
