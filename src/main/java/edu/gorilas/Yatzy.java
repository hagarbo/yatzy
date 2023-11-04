package edu.gorilas;

import java.util.Arrays;
public class Yatzy {

    private final int[]dices = {0,0,0,0,0,0,0};

    public Yatzy(int firstDice, int secondDice, int thirdDice, int fourthDice, int fifthDice) {
        this.dices[firstDice]++;
        this.dices[secondDice]++;
        this.dices[thirdDice]++;
        this.dices[fourthDice]++;
        this.dices[fifthDice]++;
    }

    public Yatzy(int[] play){
        Arrays.stream(play).forEach(dice -> this.dices[dice]++);
    }

    public int chance() {
        int sum =0;
        for (int i = 1; i < dices.length; i++) {
            sum+=dices[i]*i;
        }
        return sum;
    }

    public int yatzy() {
        for (int value : dices) {
            if (value==5) return 50;
        }
        return 0;
    }

    public int onesToSixes(int playValue){
        return  this.dices[playValue] * playValue;
    }

    private int getMinDuplicated(int times){
        for (int i = 1; i < dices.length; i++) {
            if (dices[i]>=times) return i;     
        }
        return 0;
    }

    private int getMaxDuplicated(int times){
        for (int i = 6; i > 0; i--) {
            if (dices[i]>=times) return i;     
        }
        return 0;
    }

    public int onePair() {
        return 2 * getMaxDuplicated(2);
    }

    public int twoPairs() {
        int maxPair = getMaxDuplicated(2);
        int minPair = getMinDuplicated(2);
        return (minPair==maxPair||maxPair==0||minPair==0) ? 0 : 2*maxPair+2*minPair;
    }

    public int fourOfaKind() {
        return 4 * getMaxDuplicated(4);
    }

    public int threeOfakind() {
        return 3 * this.getMaxDuplicated(3);
    }

    private boolean areAllDistinct(){
        for (int value : dices) {
            if (value>1) return false;
        }
        return true;
    }

    public int smallStraight() {
       return (areAllDistinct() && dices[6]==0) ? 15:0;
    }

    public int largeStraight() {
        return (areAllDistinct() && dices[1]==0) ? 20:0;
    }

    public int fullHouse() {
        int trio = threeOfakind();
        int pair = onePair();
        return (trio==0||pair==0)? 0 : trio+pair;
    }
}
