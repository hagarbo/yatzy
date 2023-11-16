package edu.gorilas;

import java.util.Arrays;

public class Yatzy {

    // Las posiciones 1-6 representan las caras del dado, la posicion 0 no se
    // utiliza
    private final int[] dices = { 0, 0, 0, 0, 0, 0, 0 };

    public Yatzy(int firstDice, int secondDice, int thirdDice, int fourthDice, int fifthDice) {
        this.dices[firstDice]++;
        this.dices[secondDice]++;
        this.dices[thirdDice]++;
        this.dices[fourthDice]++;
        this.dices[fifthDice]++;
    }

    public Yatzy(int[] play) {
        Arrays.stream(play).forEach(dice -> this.dices[dice]++);
    }

    public int chance() {
        int sum = 0;
        for (int i = 1; i < this.dices.length; i++) {
            sum += this.dices[i] * i;
        }
        return sum;
    }

    public int yatzy() {
        for (int value : this.dices) {
            if (value == 5)
                return 50;
        }
        return 0;
    }

    public int ones(){
        return this.onesToSixes(1);
    }

    public int twos(){
        return this.onesToSixes(2);
    }

    public int threes(){
        return this.onesToSixes(3);
    }

    public int fours(){
        return this.onesToSixes(4);
    }

    public int fives(){
        return this.onesToSixes(5);
    }

    public int sixes(){
        return this.onesToSixes(6);
    }

    private int onesToSixes(int playValue){
        return  this.dices[playValue] * playValue;
    }

    private int getMinDuplicated(int times) {
        for (int i = 1; i < this.dices.length; i++) {
            if (this.dices[i] >= times)
                return i;
        }
        return 0;
    }

    private int getMaxDuplicated(int times) {
        for (int i = 6; i > 0; i--) {
            if (this.dices[i] >= times)
                return i;
        }
        return 0;
    }

    public int onePair() {
        return 2 * this.getMaxDuplicated(2);
    }

    public int twoPairs() {
        int maxPair = this.getMaxDuplicated(2);
        int minPair = this.getMinDuplicated(2);
        return (minPair == maxPair || maxPair == 0 || minPair == 0) ? 0 : 2 * maxPair + 2 * minPair;
    }

    public int fourOfaKind() {
        return 4 * this.getMaxDuplicated(4);
    }

    public int threeOfakind() {
        return 3 * this.getMaxDuplicated(3);
    }

    private boolean areAllDistinct() {
        for (int value : dices) {
            if (value > 1)
                return false;
        }
        return true;
    }

    public int smallStraight() {
        return (this.areAllDistinct() && dices[6] == 0) ? 15 : 0;
    }

    public int largeStraight() {
        return (this.areAllDistinct() && dices[1] == 0) ? 20 : 0;
    }

    public int fullHouse() {
        int trio = threeOfakind();
        int pair = onePair();
        return (trio==0||pair==0)? 0 : trio+pair;
    }
}
