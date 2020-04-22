package com.example.demo;

import com.example.demo.marsrover.Direction;
import com.example.demo.marsrover.MarsRover;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/4/22.
 */
public class MarsRoverTest {
//    @Test
//    void demo() {
//        MarsRover marsRover = new MarsRover(0, 0, "N");
//        marsRover.send("LR");
//        assertThat(marsRover.getX()).isEqualTo(0);
//        assertThat(marsRover.getY()).isEqualTo(0);
//        assertThat(marsRover.getDirection()).isEqualTo("N");
//    }

    @Test
    void initMarsRover() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.N);
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.N);
    }

    @ParameterizedTest(name = "[{index} input arguments:({0},{1},{2}),execute command:{3},result:({4},{5},{6})")
    @MethodSource("providerArguments")
    void executeCommands(int currentX, int currentY, Direction currentDirection, String command, int expectedX, int expectedY, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(currentX, currentY, currentDirection);
        marsRover.send(command);
        assertThat(marsRover.getX()).isEqualTo(expectedX);
        assertThat(marsRover.getY()).isEqualTo(expectedY);
        assertThat(marsRover.getDirection()).isEqualTo(expectedDirection);
    }

    private static Stream<Arguments> providerArguments() {
        return Stream.of(
                //left
                Arguments.of(0, 0, Direction.N, "L", 0, 0, Direction.W),
                Arguments.of(0, 0, Direction.S, "L", 0, 0, Direction.E),
                Arguments.of(0, 0, Direction.E, "L", 0, 0, Direction.N),
                Arguments.of(0, 0, Direction.W, "L", 0, 0, Direction.S),
                Arguments.of(0, 0, Direction.W, "LL", 0, 0, Direction.E),
                Arguments.of(0, 0, Direction.W, "LLLLL", 0, 0, Direction.S),
                //right
                Arguments.of(0, 0, Direction.N, "R", 0, 0, Direction.E),
                Arguments.of(0, 0, Direction.S, "R", 0, 0, Direction.W),
                Arguments.of(0, 0, Direction.E, "R", 0, 0, Direction.S),
                Arguments.of(0, 0, Direction.W, "R", 0, 0, Direction.N),
                Arguments.of(0, 0, Direction.W, "RRR", 0, 0, Direction.S),
                //forward
                Arguments.of(0, 0, Direction.N, "F", 0, 1, Direction.N),
                Arguments.of(0, 0, Direction.S, "F", 0, -1, Direction.S),
                Arguments.of(0, 0, Direction.E, "F", 1, 0, Direction.E),
                Arguments.of(0, 0, Direction.W, "F", -1, 0, Direction.W),
                //back
                Arguments.of(0, 0, Direction.N, "B", 0, -1, Direction.N),
                Arguments.of(0, 0, Direction.S, "B", 0, 1, Direction.S),
                Arguments.of(0, 0, Direction.E, "B", -1, 0, Direction.E),
                Arguments.of(0, 0, Direction.W, "B", 1, 0, Direction.W),

                Arguments.of(0, 0, Direction.W, "BFLLRRFFFF", -4, 0, Direction.W)

        );
    }

    @Test
    void throw_exception_when_command_is_not_exist() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.N);
        Assertions.assertThrows(IllegalArgumentException.class, () -> marsRover.send("XX"));
    }

    @Test
    void position_not_change_when_command_is_empty() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.N);
        marsRover.send("");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.N);
    }


}
