package edu.gorilas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class YatzyTest {

    @Test
    public void chanceTest() {
        assertEquals(15, new Yatzy(2, 3, 4, 5, 1).chance());
        assertEquals(16, new Yatzy(3, 3, 4, 5, 1).chance());
        assertEquals(21, new Yatzy(4, 5,5,6, 1).chance());
    }

    @Test
    public void yatzyTest() {
        assertEquals(50, new Yatzy(4, 4, 4, 4, 4).yatzy());
        assertEquals(50, new Yatzy(6, 6, 6, 6, 6).yatzy());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 3).yatzy());
    }

    @Test
    public void onesTest() {
        assertTrue(new Yatzy(1, 1, 1, 1, 1).ones() == 5);
        assertEquals(2,new  Yatzy(1, 2, 1, 4, 5).ones());
        assertEquals(0, new Yatzy(6, 2, 2, 4, 5).ones());
        assertEquals(4, new Yatzy(1, 2, 1, 1, 1).ones());
    }

    @Test
    public void twosTest() {
        assertEquals(0, new Yatzy(6, 3, 1, 4, 5).twos());
        assertEquals(4, new Yatzy(1, 2, 3, 2, 6).twos());
        assertEquals(10, new Yatzy(2, 2, 2, 2, 2).twos());
    }

    @Test
    public void threesTest() {
        assertEquals(6, new Yatzy(1, 2, 3, 2, 3).threes());
        assertEquals(12, new Yatzy(2, 3, 3, 3, 3).threes());
    }

    @Test
    public void foursTest() {
        assertEquals(12, new Yatzy(4, 4, 4, 5, 5).fours());
        assertEquals(8, new Yatzy(4, 4, 5, 5, 5).fours());
        assertEquals(4, new Yatzy(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fivesTest() {
        assertEquals(10, new Yatzy(4, 4, 4, 5, 5).fives());
        assertEquals(15, new Yatzy(4, 4, 5, 5, 5).fives());
        assertEquals(20, new Yatzy(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixesTest() {
        assertEquals(0, new Yatzy(4, 4, 4, 5, 5).sixes());
        assertEquals(6, new Yatzy(4, 4, 6, 5, 5).sixes());
        assertEquals(18, new Yatzy(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void onePair() {
        assertEquals(0,new  Yatzy(3, 4, 2, 5, 6).onePair());
        assertEquals(6,new  Yatzy(3, 4, 3, 5, 6).onePair());
        assertEquals(10,new  Yatzy(5, 3, 3, 3, 5).onePair());
        assertEquals(12, new Yatzy(5, 3, 6, 6, 5).onePair());
    }

    @Test
    public void twoPair() {
        assertEquals(0,new Yatzy(3, 3, 3, 4, 3).twoPairs());
        assertEquals(8,new Yatzy(1, 1, 2, 3, 3).twoPairs());
        assertEquals(16, new Yatzy(3, 3, 5, 5, 5).twoPairs());
        assertEquals(6, new Yatzy(1, 1, 2, 2, 2).twoPairs());
    }

    @Test
    public void threeOfaKind() {
        assertEquals(9, new Yatzy(3, 3, 3, 4, 5).threeOfakind());
        assertEquals(15,new Yatzy(5, 3, 5, 4, 5).threeOfakind());
        assertEquals(9,new Yatzy(3, 3, 3, 3, 5).threeOfakind());
        assertEquals(0,new Yatzy(3, 3, 4, 5, 6).threeOfakind());
    }

    @Test
    public void fourOfaKind() {
        assertEquals(12,new Yatzy(3, 3, 3, 3, 5).fourOfaKind());
        assertEquals(20,new Yatzy(5, 5, 5, 4, 5).fourOfaKind());
        assertEquals(12,new Yatzy(3, 3, 3, 3, 3).fourOfaKind());
        assertEquals(0,new Yatzy(1, 2, 3, 4, 5).fourOfaKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15,new  Yatzy(1, 2, 3, 4, 5).smallStraight());
        assertEquals(15,new  Yatzy(2, 3, 4, 5, 1).smallStraight());
        assertEquals(0,new Yatzy(1, 2, 2, 4, 5).smallStraight());
        assertEquals(0,new Yatzy(6, 6, 6, 6, 6).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6, 2, 3, 4, 5).largeStraight());
        assertEquals(20, new Yatzy(2, 3, 4, 5, 6).largeStraight());
        assertEquals(0, new Yatzy(1, 2, 2, 4, 5).largeStraight());
        assertEquals(0, new Yatzy(6, 6, 6, 6, 6).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18,new Yatzy(6, 2, 2, 2, 6).fullHouse());
        assertEquals(0,new Yatzy(2, 3, 4, 5, 6).fullHouse());
        assertEquals(0,new Yatzy(4, 4, 4, 4, 4).fullHouse());
    }
}
