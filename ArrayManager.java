package sortingalgorithmvisualizer;

import java.util.Random;

public class ArrayManager {
    
    public static int[] randomArrayGenerator(int arrLength) {
        Random random = new Random();
        int[] temp = new int[arrLength];
        for(int i=0; i<temp.length; i++) {
            temp[i] = random.nextInt(540)+11; // Array can have values from 10-550.
//            if(temp[i]==550) {
//                System.out.println(temp[i]);
//            }
        }
        return temp;
    }
    public static int[] normalArrayGenerator(int arrLength) {
        int[] temp = new int[arrLength];
        int val = 11;
        for(int i=0; i<temp.length; i++) {
            temp[i] = val; // Array can have values from (11-510).
            val++;
//            if(temp[i]==550) {
//                System.out.println(temp[i]);
//            }
        }
        return temp;
    }
    
}
