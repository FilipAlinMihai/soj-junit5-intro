package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static com.endava.tmd.soj.junit5.p07.Score.*;
// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {

    public Score score;
    @BeforeEach
    void initializare() {
         score= new Score();
    }

    @Test
    void test1()
    {
        assertThat(score.getPercent()).isEqualTo("100.0");
    }

    @Test
    void test2()
    {
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        score.addIncorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("33.3");
    }


    @Test
    void test3()
    {
        score.addCorrectAnswer();
        score.addIncorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("50.0");
    }


}
