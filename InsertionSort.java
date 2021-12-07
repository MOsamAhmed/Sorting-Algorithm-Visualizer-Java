package sortingalgorithmvisualizer;

public class InsertionSort {
    private int arrayIndex;
    private int compareIndex;
    private int key;
    private boolean isIterating;
    private int[] array;
    
    public InsertionSort(int[] array) {
//        arrayIndex = 0;
        arrayIndex = Integer.MAX_VALUE;
        compareIndex = Integer.MAX_VALUE;
        key = Integer.MAX_VALUE;
        isIterating = false;
//        minIndex = Integer.MAX_VALUE;
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
    
//    public int getMinIndex() {
//        return minIndex;
//    }
//    public void setMinIndex(int minIndex) {
//        this.minIndex = minIndex;
//    }
    
    public void insertionSortOnlyOneItem() {
//        checking if nested loop ended and also incrementing nested loop pointer
        if(!isIterating) {
            key = array[arrayIndex];
            compareIndex = arrayIndex-1;
            isIterating = true;
//            minIndex = compareIndex;
        }
        
//        inside nested loop
        if(compareIndex >= 0 && array[compareIndex]>key) {
            array[compareIndex+1] = array[compareIndex];
            compareIndex--;
        }
        
//        nested loop ended and incrementing outer loop
//        and positioning key value at right place in the back
        else {
            array[compareIndex+1] = key;
            arrayIndex++;
            isIterating = false;
            
//            int temp = array[minIndex];
//            array[minIndex] = array[arrayIndex];
//            array[arrayIndex] = temp;
//            arrayIndex++;
//            minIndex = arrayIndex;
//            compareIndex = arrayIndex+1;
        }
    }
    
}
