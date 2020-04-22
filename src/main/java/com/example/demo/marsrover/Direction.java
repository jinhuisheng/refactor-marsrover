package com.example.demo.marsrover;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public enum Direction {
    N("W", "E"),
    S("E", "W"),
    E("N", "S"),
    W("S", "N");
    private String left;
    private String right;

    Direction(String left, String right) {
        this.left = left;
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
