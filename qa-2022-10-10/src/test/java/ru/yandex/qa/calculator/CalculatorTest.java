package ru.yandex.qa.calculator;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    @Order(1)
    @DisplayName("Тест вычитания")
    void testDiff() {
        int diff = calculator.diff(10, 8);
        int diff1 = calculator.diff(8, 6);
        int diff2 = calculator.diff(14, 12);
        int diff3 = calculator.diff(-2, -4);

        Assertions.assertAll(
                () -> Assertions.assertEquals(2, diff),
                () -> Assertions.assertEquals(2, diff1),
                () -> Assertions.assertEquals(2, diff2),
                () -> Assertions.assertEquals(2, diff3)
        );
    }

    @Order(2)
    @ParameterizedTest(name = "{index}. Вычитание чисел {arguments}")
    @MethodSource("getValuesForDiff")
    @DisplayName("Тесты вычитания")
    void testDiff2(int[] values) {
        int diff = calculator.diff(values[0], values[1]);
        Assertions.assertEquals(2, diff);
    }

    private static Stream<int[]> getValuesForDiff() {
        return Stream.of(
                new int[]{10, 8},
                new int[]{8, 6},
                new int[]{14, 12},
                new int[]{-2, -4}
        );
    }

    @Order(3)
    @ParameterizedTest(name = "{index}. Для числа {arguments} модуль равен 25")
    @ValueSource(ints = {25, -25})
    @DisplayName("Тест модуля")
    void testAbc(int a) {
        int abc = calculator.abc(a);
        Assertions.assertEquals(25, abc);
    }

    @Test
    @Order(4)
    void testDivision() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> calculator.division(20, 0));
    }
}