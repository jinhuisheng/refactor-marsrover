package com.example.demo;

/**
 * @author huisheng.jin
 * @date 2020/4/26.
 */
public class MarsRover {
    private final Integer x;
    private final Integer y;
    private String direction;

    public MarsRover(Integer x, Integer y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public String getDirection() {
        return direction;
    }

    public void send(String command) {
        if (this.direction.equals("S")) {
            this.direction = "E";
        } else if (this.direction.equals("E")) {
            this.direction = "N";
        } else if (this.direction.equals("N")) {
            this.direction = "W";
        } else if (this.direction.equals("W")) {
            this.direction = "S";
        }
    }

}
