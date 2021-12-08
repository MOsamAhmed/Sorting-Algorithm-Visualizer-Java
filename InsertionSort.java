package sortingalgorithmvisualizer;

public class InsertionSort {
    private int arrayIndex;
    private int compareIndex;
    private int key;
    private boolean isIterating;
    private int[] array;
    
    public InsertionSort(int[] array) {
        arrayIndex = Integer.MAX_VALUE;
        compareIndex = Integer.MAX_VALUE;
        key = Integer.MAX_VALUE;
        isIterating = false;
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
    
    public void insertionSortOnlyOneItem() {
//        checking if nested loop ended and also incrementing nested loop pointer
        if(!isIterating) {
            key = array[arrayIndex];
            compareIndex = arrayIndex-1;
            isIterating = true;
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
        }
    }
    
}
