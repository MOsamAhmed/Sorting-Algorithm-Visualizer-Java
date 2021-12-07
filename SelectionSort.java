package sortingalgorithmvisualizer;

public class SelectionSort {
    private int arrayIndex;
    private int compareIndex;
    private int minIndex;
    private int[] array;
    
    public SelectionSort(int[] array) {
//        arrayIndex = 0;
        arrayIndex = Integer.MAX_VALUE;
        compareIndex = Integer.MAX_VALUE;
        minIndex = Integer.MAX_VALUE;
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
    
    public int getMinIndex() {
        return minIndex;
    }
    public void setMinIndex(int minIndex) {
        this.minIndex = minIndex;
    }
    
    public void selectionSortOnlyOneItem() {
//        inside nested loop
        if(array[compareIndex]<array[minIndex]) {
            minIndex = compareIndex;
        }
        
//        checking if nested loop ended and also incrementing nested loop pointer
        if((compareIndex) < (array.length-1)) {
            compareIndex++;
        }
        
//        nested loop ended and incrementing outer loop
        else {
            int temp = array[minIndex];
            array[minIndex] = array[arrayIndex];
            array[arrayIndex] = temp;
            arrayIndex++;
            minIndex = arrayIndex;
            compareIndex = arrayIndex+1;
        }
    }
    
}
