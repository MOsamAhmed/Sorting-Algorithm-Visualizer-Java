package sortingalgorithmvisualizer;

public class QuickSort {
//    private int arrayIndex;
    private int pivotIndex;
    private int startIndex;
    private int endIndex;
    private boolean startIndexPositioned;
    private boolean endIndexPositioned;
    private int[] array;
    
    public QuickSort(int[] array) {
//        arrayIndex = 0;
//        arrayIndex = Integer.MAX_VALUE;
        pivotIndex = Integer.MAX_VALUE;
        startIndex = Integer.MAX_VALUE;
        endIndex = Integer.MAX_VALUE;
        startIndexPositioned = false;
        endIndexPositioned = false;
        this.array = array;
    }
    
    public void selectionSortOnlyOneItem() {
//        inside nested loop
        if(array[startIndex]<=array[pivotIndex] && startIndexPositioned==false) {
            startIndex++;
            if(startIndex>=array.length) {
                startIndexPositioned = true;
            }
        } else {
            startIndexPositioned = true;
        }
        if(array[endIndex]>array[pivotIndex]) {
            endIndex--;
        } else {
            endIndexPositioned = true;
        }
        
        if(startIndexPositioned && endIndexPositioned) {
            if(startIndex<endIndex) {
                swap(startIndex, endIndex);
                startIndex++;
                endIndex--;
                startIndexPositioned = false;
                endIndexPositioned = false;
            }
            else if(startIndex>endIndex) {
                swap(pivotIndex, endIndex);
                int temp = pivotIndex;
                pivotIndex = 0;
                startIndex = pivotIndex+1;
                endIndex = temp-1;
                selectionSortOnlyOneItem();
                pivotIndex = temp+1;
                startIndex = pivotIndex+1;
                endIndex = array.length-1;
            }
        }
        
//        checking if nested loop ended and also incrementing nested loop pointer
//        if((pivotIndex) < (array.length-1)) {
//            pivotIndex++;
//        }
        
//        nested loop ended and incrementing outer loop
//        else {
//            swap(startIndex, arrayIndex);
//            arrayIndex++;
//            startIndex = arrayIndex;
//            pivotIndex = arrayIndex+1;
//        }
    }
    
    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public int [] getArray() {
        return array;
    }
    public void setArray(int[] array) {
        this.array = array;
    }
    
//    public int getArrayIndex() {
//        return arrayIndex;
//    }
//    public void setArrayIndex(int arrayIndex) {
//        this.arrayIndex = arrayIndex;
//    }
    
    public int getPivotIndex() {
        return pivotIndex;
    }
    public void setPivotIndex(int pivotIndex) {
        this.pivotIndex = pivotIndex;
    }
    
    public int getStartIndex() {
        return startIndex;
    }
    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
    
    public int getEndIndex() {
        return endIndex;
    }
    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
    
    
}
