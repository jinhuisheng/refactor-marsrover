package com.example.demo.marsrover;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public enum Direction {
    E("N", "S"),
    W("S", "N"),
    N("W", "E"),
    S("E", "W");

    private String left;
    private String right;

    Direction(String left, String right) {
        this.right = right;
        this.left = left;
    }

    public Direction left() {
        return valueOf(left);
    }

    public Direction right() {
        return valueOf(right);
    }

}
