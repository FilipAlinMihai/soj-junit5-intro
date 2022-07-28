package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.endava.tmd.soj.junit5.p03.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class ComputationUtilsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void azeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        //assertThat(sum(1, 0)).isZero();
    }

    @Test
    @DisplayName("0 + 3 = 3")
    void bzeroShouldNotChangePositive() {

        assertThat(sum(0, 3)).isEqualTo(3);
    }

    @Test
    @DisplayName("0 - 3 = -3")
    void czeroShouldNotChangeNegative() {
        assertThat(sum(0, -3)).isEqualTo(-3);
    }

    @Test
    @DisplayName("1 + 3 = 4")
    void dtwoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {

        assertThat(sum(1, 3)).isEqualTo(4);
    }

    @Test
    @DisplayName("-1 - 3 = -4")
    void etwoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertThat(sum(-1, -3)).isEqualTo(-4);
    }

    @Test
    @DisplayName("-2 + 3 = 1")
    void foneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {

        assertThat(sum(-2, 3)).isEqualTo(1);
    }
    @Test
    @DisplayName("2 - 3 = -1")
    void goneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2, -3)).isEqualTo(-1);
    }

}
