package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + {1}")
    @CsvSource(value = {
            "1, 2",
            "-1, -1",
            "0, 7",
            "0, 0",
            "3, -2"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void testSuma(int a,int b)
    {
        assertThat(sum(a, b)).isEqualTo(a+b);
    }

    @ParameterizedTest(name = "{0} + {1}")
    @CsvSource(value = {
            "2147483647, 1",
            "-2147483647, -2"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void testExceptii(int a,int b)
    {
        assertThatThrownBy(() -> sum(a, b))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }


}
