package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
 */
public class MarsRoverTest {
//    @Test
//    void demo() {
//        MarsRover marsRover = new MarsRover(0, 0, "N");
//        marsRover.send("F");
//        assertThat(marsRover.getX()).isEqualTo(0);
//        assertThat(marsRover.getY()).isEqualTo(1);
//        assertThat(marsRover.getDirection()).isEqualTo("N");
//    }
//
    @Test
    void 初始化火星车_0_0_N_并正确获取火星车位置() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.NORTH);
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @ParameterizedTest(name = "{index} 当前位置({0},{1}),{2},执行命令 {3} 后的位置是（{4},{5}),{6}")
    @MethodSource("provideExecuteCommandsArguments")
    void move(int currentX, int currentY, Direction currentDirection, String commands, int expectedX, int expectedY, Direction expectedDirection) {
        MarsRover marsRover = new MarsRover(currentX, currentY, currentDirection);
        marsRover.execute(commands);
        assertThat(marsRover.getX()).isEqualTo(expectedX);
        assertThat(marsRover.getY()).isEqualTo(expectedY);
        assertThat(marsRover.getDirection()).isEqualTo(expectedDirection);
    }

    private static Stream<Arguments> provideExecuteCommandsArguments() {

        return Stream.of(
                //左转
                Arguments.of(0, 0, Direction.NORTH, "L", 0, 0, Direction.WEST),
                Arguments.of(0, 0, Direction.NORTH, "LL", 0, 0, Direction.SOUTH),
                Arguments.of(0, 0, Direction.NORTH, "LLL", 0, 0, Direction.EAST),
                Arguments.of(0, 0, Direction.NORTH, "LLLL", 0, 0, Direction.NORTH),

                //右转
                Arguments.of(0, 0, Direction.NORTH, "R", 0, 0, Direction.EAST),
                Arguments.of(0, 0, Direction.NORTH, "RR", 0, 0, Direction.SOUTH),
                Arguments.of(0, 0, Direction.NORTH, "RRR", 0, 0, Direction.WEST),
                Arguments.of(0, 0, Direction.NORTH, "RRRR", 0, 0, Direction.NORTH),
                Arguments.of(0, 0, Direction.NORTH, "RLLLR", 0, 0, Direction.WEST),
                Arguments.of(0, 0, Direction.NORTH, "LLLRLLLR", 0, 0, Direction.NORTH),

                //前进
                Arguments.of(0, 0, Direction.NORTH, "F", 0, 1, Direction.NORTH),
                Arguments.of(0, 0, Direction.EAST, "F", 1, 0, Direction.EAST),
                Arguments.of(0, 0, Direction.WEST, "F", -1, 0, Direction.WEST),
                Arguments.of(0, 0, Direction.SOUTH, "F", 0, -1, Direction.SOUTH),

                //后退
                Arguments.of(0, 0, Direction.SOUTH, "B", 0, 1, Direction.SOUTH),
                Arguments.of(0, 0, Direction.NORTH, "B", 0, -1, Direction.NORTH),
                Arguments.of(0, 0, Direction.EAST, "B", -1, 0, Direction.EAST),
                Arguments.of(0, 0, Direction.WEST, "B", 1, 0, Direction.WEST),

                // 执行多种指令
                Arguments.of(0, 0, Direction.NORTH, "FLB", 1, 1, Direction.WEST),
                Arguments.of(0, 0, Direction.NORTH, "FRBLBBBB", -1, -3, Direction.NORTH)
        );
    }

}
