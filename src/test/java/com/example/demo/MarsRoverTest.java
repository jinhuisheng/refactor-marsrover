package com.example.demo;

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
        assertThat(marsRover.getDirection()).isEqualTo(Direction.N);
    }

    @ParameterizedTest(name = "[{index}] current position ({0},{1},{2}),execute commands {3},result:({4},{5},{6})")
    @MethodSource({"provideArguments"})
    void assert_commands_execute_result(Integer currentX, Integer currentY, Direction currentDirection,
                                        String commands,
                                        Integer expectedX, Integer expectedY, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(currentX, currentY, currentDirection);
        marsRover.sendCommands(commands);
        assertThat(marsRover.getX()).isEqualTo(expectedX);
        assertThat(marsRover.getY()).isEqualTo(expectedY);
        assertThat(marsRover.getDirection()).isEqualTo(expectedDirection);
    }

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                // 左转
                Arguments.of(0, 0, Direction.N, "L", 0, 0, Direction.W),
                Arguments.of(0, 0, Direction.W, "L", 0, 0, Direction.S),
                Arguments.of(0, 0, Direction.S, "L", 0, 0, Direction.E),
                Arguments.of(0, 0, Direction.E, "L", 0, 0, Direction.N),
                Arguments.of(0, 0, Direction.E, "LL", 0, 0, Direction.W),

                //右转
                Arguments.of(0, 0, Direction.N, "R", 0, 0, Direction.E),
                Arguments.of(0, 0, Direction.W, "R", 0, 0, Direction.N),
                Arguments.of(0, 0, Direction.S, "R", 0, 0, Direction.W),
                Arguments.of(0, 0, Direction.E, "R", 0, 0, Direction.S),
                Arguments.of(0, 0, Direction.E, "RR", 0, 0, Direction.W),
                Arguments.of(0, 0, Direction.E, "RRRRRL", 0, 0, Direction.E),

                //向前
                Arguments.of(0, 0, Direction.N, "F", 0, 1, Direction.N),
                Arguments.of(0, 0, Direction.S, "F", 0, -1, Direction.S),
                Arguments.of(0, 0, Direction.E, "F", 1, 0, Direction.E),
                Arguments.of(0, 0, Direction.W, "F", -1, 0, Direction.W)


        );
    }

}
