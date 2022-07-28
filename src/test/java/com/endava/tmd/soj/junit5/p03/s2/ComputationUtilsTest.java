package com.endava.tmd.soj.junit5.p03.s2;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p03.s2.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ComputationUtilsTest {

    @Test
    @Order(1)
    @DisplayName("0 + 0 = 0")
    void azeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));

        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
        //assertThat(sum(1, 0)).isZero();
    }

    @Test
    @Order(2)
    @DisplayName("0 + 3 = 3")
    void bzeroShouldNotChangePositive() {

        assertThat(sum(0, 3)).isEqualTo(3);
    }

    @Test
    @Order(3)
    @DisplayName("0 - 3 = -3")
    void czeroShouldNotChangeNegative() {
        assertThat(sum(0, -3)).isEqualTo(-3);
    }

    @Test
    @Order(4)
    @DisplayName("1 + 3 = 4")
    void dtwoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {

        assertThat(sum(1, 3)).isEqualTo(4);
    }

    @Test
    @Order(5)
    @DisplayName("-1 - 3 = -4")
    void etwoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {

        assertThat(sum(-1, -3)).isEqualTo(-4);
    }

    @Test
    @Order(6)
    @DisplayName("-2 + 3 = 1")
    void foneSmallNegativeAndOneBigPosiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {

        assertThat(sum(-2, 3)).isEqualTo(1);
    }
    @Test
    @Order(7)
    @DisplayName("2 - 3 = -1")
    void goneBigNegativeAndOneSmallPosiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertThat(sum(2, -3)).isEqualTo(-1);
    }

}
