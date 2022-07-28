package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumente")
    void testSuma(int a)
    {
        assertThat(sum(a, 1)).isEqualTo(a+1);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("argumente1")
    void testExceptii(int a)
    {
        assertThatThrownBy(() -> sum(a, 2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }



    static IntStream argumente() {
        return IntStream.range(1, 3);
    }


    static IntStream argumente1() {
        return IntStream.of(Integer.MAX_VALUE,Integer.MAX_VALUE-1);
    }
}
