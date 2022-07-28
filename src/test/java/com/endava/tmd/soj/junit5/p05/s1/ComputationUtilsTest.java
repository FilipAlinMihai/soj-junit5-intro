package com.endava.tmd.soj.junit5.p05.s1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// Provocare: Copiati metodele de test din tema precedenta, si adaugati ceea ce lipseste astfel incat
// sa fie testate si scenariile urmatoare
class ComputationUtilsTest {

    @Test
   @DisplayName("2147483647 + 1 \u21D2 Overflow")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @Test
    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    void exceptionWhenSumIsLowerThanIntegerMinValue() {

        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> sum(-2147483647, -2));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(-2147483647, -2));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(-2147483647, -2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }
    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        //assertThat(sum(1, 0)).isZero();
    }

    @Test
    @DisplayName("0 + 3 = 3")
    void zeroShouldNotChangePositive() {

        assertThat(sum(0, 3)).isEqualTo(3);
    }

    @Test
    @DisplayName("0 - 3 = -3")
    void zeroShouldNotChangeNegative() {
        assertThat(sum(0, -3)).isEqualTo(-3);
    }

    @Test
    @DisplayName("1 + 3 = 4")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {

        assertThat(sum(1, 3)).isEqualTo(4);
    }

    @Test
    @DisplayName("-1 - 3 = -4")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertThat(sum(-1, -3)).isEqualTo(-4);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    void oneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {

        assertThat(sum(-2, 3)).isEqualTo(1);
    }
    @Test
    @DisplayName("2 - 3 = -1")
    void oneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2, -3)).isEqualTo(-1);
    }
    @Test
    @DisplayName("0 + 2147483647 = 2147483647")
    void zeroShouldNotChangeMaxInt() {

        assertThat(sum(0, Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }

    @Test
    @DisplayName("-1 + 2147483647 = 2147483646")
    void maxIntAndANegativeNumber() {
        assertThat(sum(-1, Integer.MAX_VALUE)).isEqualTo(2147483646);
    }

    @Test
    @DisplayName("0 - 2147483648 = - 2147483648")
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(0, Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    @DisplayName("2147483646 - 2147483648 = - 2")
    void minIntAndAPositiveNumber() {
        assertThat(sum(2147483646, Integer.MIN_VALUE)).isEqualTo(-2);

    }

    @Test
    @DisplayName("2147483647 - 2147483648 = - 1")
    void minIntAndMaxInt() {
        assertThat(sum(Integer.MAX_VALUE, Integer.MIN_VALUE)).isEqualTo(-1);
    }

    @Test
    @DisplayName("2147483646 + 1 = skipped")
    @Disabled("skipped")
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE, 1)).isGreaterThan(Integer.MAX_VALUE);
    }
}
