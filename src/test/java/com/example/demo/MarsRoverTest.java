package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/4/16.
 */
public class MarsRoverTest {

    private MarsRover marsRover;

    @BeforeEach
    void setUp() {
        marsRover = new MarsRover(0, 0, Direction.NORTH);
    }

    @Test
    void 初始化火星车_0_0_N_并正确获取火星车位置() {
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @ParameterizedTest(name = "{index} 执行一批命令{0},得到结果为{1}")
    @MethodSource("provideBaseInfoArguments")
    void 初始信息_0_0_N的火星车_转向(String commands, Direction expectedDirection) {
        marsRover.execute(commands);
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo(expectedDirection);
    }

    private static Stream<Arguments> provideBaseInfoArguments() {
        return Stream.of(
                Arguments.of("L", Direction.WEST),
                Arguments.of("LL", Direction.SOUTH),
                Arguments.of("LLL", Direction.EAST),
                Arguments.of("LLLL", Direction.NORTH),
                Arguments.of("R", Direction.EAST),
                Arguments.of("RR", Direction.SOUTH),
                Arguments.of("RRR", Direction.WEST),
                Arguments.of("RRRR", Direction.NORTH),
                Arguments.of("RLLLR", Direction.WEST),
                Arguments.of("LLLRLLLR", Direction.NORTH)
        );
    }

    @Test
    void 初始化火星车_0_0_N_向前移动一步() {
        marsRover.execute("F");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(1);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void 初始化火星车_0_0_N_向前移动2步() {
        marsRover.execute("FF");
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(2);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.NORTH);
    }

    @Test
    void 初始化火星车_0_0_S_向前移动一步() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.SOUTH);
        marsRover.moveFront();
        assertThat(marsRover.getX()).isEqualTo(0);
        assertThat(marsRover.getY()).isEqualTo(-1);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void 初始化火星车_0_0_E_向前移动一步() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.EAST);
        marsRover.moveFront();
        assertThat(marsRover.getX()).isEqualTo(1);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.EAST);
    }

    @Test
    void 初始化火星车_0_0_W_向前移动一步() {
        MarsRover marsRover = new MarsRover(0, 0, Direction.WEST);
        marsRover.moveFront();
        assertThat(marsRover.getX()).isEqualTo(-1);
        assertThat(marsRover.getY()).isEqualTo(0);
        assertThat(marsRover.getDirection()).isEqualTo(Direction.WEST);
    }
//
}
