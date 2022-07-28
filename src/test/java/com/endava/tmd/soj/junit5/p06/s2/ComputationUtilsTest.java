package com.endava.tmd.soj.junit5.p06.s2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p06.s2.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

// Provocare: Rescrieti testul care verifica valoarea sumei a doua numere din tema precedenta
// folosind un fisier (Comma-Separated Value) care sa stocheze datele necesare pentru test
// Fisierul se va numi "sumCheckArguments.csv" si va fi creat in folderul src/test/resources
// Se va utiliza adnotarea @CsvFileSource.
// 
// Testul care verifica exceptiile generate se va copia din tema precedenta
class ComputationUtilsTest {

    @ParameterizedTest(name = "{0} + {1}")
    @CsvFileSource(resources = "/sumCheckArguments.csv", numLinesToSkip = 0)
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
