package sortingalgorithmvisualizer;

import java.util.ArrayList;
import java.util.Random;

public class ArrayManager {
    
//    static Random random = new Random();
//    private static ArrayList<Integer> normalArrayListGenerator() {
//        ArrayList<Integer> temp = new ArrayList<>();
//        for(int i=0; i<)
//        return temp;
//    }
    
    public static int[] randomArrayGenerator(int arrLength) {
//        int[] temp = new int[500];
        Random random1 = new Random();
        int[] temp = new int[arrLength];
        for(int i=0; i<temp.length; i++) {
            temp[i] = random1.nextInt(540)+10;
        }
        return temp;
    }
    
}
