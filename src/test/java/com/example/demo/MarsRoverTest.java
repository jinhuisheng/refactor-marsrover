package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public class MarsRoverTest {
//    @Test
//    void demo() {
//        MarsRover marsRover = new MarsRover(0,0,"N");
//        marsRover.sendCommands("LL");
//        assertThat(marsRover.getX()).isEqualTo(0);
//        assertThat(marsRover.getY()).isEqualTo(0);
//        assertThat(marsRover.getDrection()).isEqualTo("N");
//    }

    @Test
    void init_marsRover() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.N);
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirectionEnum()).isEqualTo(Direction.N);
    }

    @Test
    void turn_left_once_is_W_when_current_direction_is_N() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.N);
        marsRover.sendCommands("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirectionEnum()).isEqualTo(Direction.W);
    }

    @Test
    void turn_left_once_is_S_when_current_direction_is_W() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.W);
        marsRover.sendCommands("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirectionEnum()).isEqualTo(Direction.S);
    }

    @Test
    void turn_left_once_is_E_when_current_direction_is_S() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.S);
        marsRover.sendCommands("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirectionEnum()).isEqualTo(Direction.E);
    }

    @Test
    void turn_left_once_is_N_when_current_direction_is_E() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.E);
        marsRover.sendCommands("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirectionEnum()).isEqualTo(Direction.N);
    }


}
