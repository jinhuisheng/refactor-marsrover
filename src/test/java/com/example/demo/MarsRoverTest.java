package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/4/26.
 */
public class MarsRoverTest {
//    @Test
//    void demo() {
//        MarsRover marsRover = new MarsRover(0, 0, "N");
//        marsRover.send("LL");
//        assertThat(marsRover.getX()).isEqualTo(0);
//        assertThat(marsRover.getY()).isEqualTo(0);
//        assertThat(marsRover.getDirection()).isEqualTo("S");
//    }


    @Test
    void init_marsRover() {
        MarsRover marsRover = new MarsRover(0, 0, "N");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo("N");
    }

    @Test
    void direction_change_from_N_to_W_when_turn_left() {
        MarsRover marsRover = new MarsRover(0, 0, "N");
        marsRover.send("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo("W");
    }

    @Test
    void direction_change_from_S_to_E_when_turn_left() {
        MarsRover marsRover = new MarsRover(0, 0, "S");
        marsRover.send("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo("E");
    }

    @Test
    void direction_change_from_E_to_N_when_turn_left() {
        MarsRover marsRover = new MarsRover(0, 0, "E");
        marsRover.send("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo("N");
    }

    @Test
    void direction_change_from_W_to_S_when_turn_left() {
        MarsRover marsRover = new MarsRover(0, 0, "W");
        marsRover.send("L");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo("S");
    }

}
