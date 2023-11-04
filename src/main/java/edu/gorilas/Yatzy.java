package edu.gorilas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Yatzy {

    private final ArrayList<Integer> play = new ArrayList<>();

    public Yatzy(int firstDice, int secondDice, int thirdDice, int fourthDice, int fifthDice) {
        this.play.add(firstDice);
        this.play.add(secondDice);
        this.play.add(thirdDice);
        this.play.add(fourthDice);
        this.play.add(fifthDice);
    }

    public Yatzy(int[] play){
        Arrays.stream(play).forEach(dice -> this.play.add(dice));
    }

    private  boolean areAllDistinct(){
        return  (this.play.stream().distinct().count() == this.play.size());
    }

    private int getMinDice(){
        return this.play.stream().mapToInt(v->v).min().orElse(0);
    }

    private int getMaxDice(){
        return this.play.stream().mapToInt(v->v).max().orElse(0);
    }

    private int countDicesByValue(int value){
        return (int) this.play.stream().filter(num -> num==value).count();
    }

    public int chance() {
        return this.play.stream().mapToInt(v->v).sum();
    }

    public int yatzy() {
        return (getMaxDuplicated(5)!=0) ? 50 : 0;
    }

    public int onesToSixes(int playValue){
        return  this.countDicesByValue(playValue)*playValue;
    }

    private int getMaxDuplicated(int times){
        return this.play.stream()
                .filter(dice->Collections
                .frequency(play, dice)>=times)
                .mapToInt(v->v).max().orElse(0);
    }

    private Set<Integer> getPairs(){
        return this.play.stream()
                .filter(dice->Collections
                .frequency(play, dice)>1)
                .collect(Collectors.toSet());
    }

    public int onePair() {
        return this.getMaxDuplicated(2)*2;
    }

    public int twoPairs() {
        Set<Integer> pairs = this.getPairs(); 
        return (pairs.size()==2)? pairs.stream().reduce(0, (result, dice)->result+(dice*2)) : 0;
    }

    public int fourOfaKind() {
        return this.getMaxDuplicated(4) *4;
    }

    public int threeOfakind() {
        return this.getMaxDuplicated(3) *3;
    }

    public int smallStraight() {
       return (areAllDistinct() && getMinDice()==1 && getMaxDice()==5) ? 15:0;
    }

    public int largeStraight() {
        return (areAllDistinct() && getMinDice()==2 && getMaxDice()==6) ? 20:0;
    }

    public int fullHouse() {
        int trio = threeOfakind();
        int pair = onePair();
        return (trio==0||pair==0)? 0 : trio+pair;
    }
}
