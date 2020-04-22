package com.example.demo;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public enum Direction {
    N("W", "N", "E"),
    S("E", "S", "W"),
    E("N", "E", "S"),
    W("S", "W", "N");
    private String left;
    private String name;
    private String right;

    Direction(String left, String name, String right) {
        this.left = left;
        this.name = name;
        this.right = right;
    }

    public Direction right() {
        return getValue(this.right);
    }

    private Direction getValue(String name) {
        return valueOf(name);
    }

    public Direction left() {
        return getValue(this.left);
    }

}
