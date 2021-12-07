package sortingalgorithmvisualizer;

public class BubbleSort {
    private int arrayIndex;
    private int compareIndex;
    private int[] array;
    
    public BubbleSort(int[] array) {
        arrayIndex = 0;
        compareIndex = Integer.MAX_VALUE;
        this.array = array;
    }
    
    public void setArray(int[] array) {
        this.array = array;
    }
    
    public int getArrayIndex() {
        return arrayIndex;
    }
    public void setArrayIndex(int arrayIndex) {
        this.arrayIndex = arrayIndex;
    }
    
    public int getCompareIndex() {
        return compareIndex;
    }
    public void setCompareIndex(int compareIndex) {
        this.compareIndex = compareIndex;
    }
    
    public void bubbleSortOnlyOneItem() {
//        inside nested loop
        if(array[compareIndex]>array[compareIndex+1]) {
            int temp = array[compareIndex];
            array[compareIndex] = array[compareIndex+1];
            array[compareIndex+1] = temp;
        }
        
//        checking if nested loop ended and also incrementing nested loop pointer
        if((compareIndex+1) < (array.length-arrayIndex-1)) {
            compareIndex++;
        }
        
//        nested loop ended and incrementing outer loop
        else {
            arrayIndex++;
            compareIndex = 0;
        }
    }
    
}
