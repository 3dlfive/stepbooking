package utils;

import java.util.Random;

public class Randomizer {
    public static int getRandomUnder(int max){
        return  new Random().nextInt(max);
    }
    public  static int genRandomBetwen(int min, int max){
        return (new Random().nextInt(max - min) + min);
    }
}
