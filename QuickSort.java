package sortingalgorithmvisualizer;

public class QuickSort {
    
    private int low;
    private int high;
    private int stackPointer;
    private int arrayIndex;
    private int compareIndex;
    private int pivotElement;
    private int partitionIndex;
    private boolean isPartioning;
    private int[] array;
    private int[] stack;

    public QuickSort(int[] array) {
        this.array = array;
        stack = new int[this.array.length];
        low = 0;
        high = stack.length-1;
//        arrayIndex = 0;
//        compareIndex = 0;
        arrayIndex = Integer.MAX_VALUE;
        compareIndex = Integer.MAX_VALUE;
        pivotElement = 0;
        partitionIndex = -1;
        
        stackPointer = -1;
        stackPointer++;
        stack[stackPointer] = 0;
        stackPointer++;
        stack[stackPointer] = stack.length-1;
        
        isPartioning = false;
    }

  
    // Sorts arr[l..h] using iterative QuickSort
    public void sortOnlyOneItem() {
  
        // keep popping elements until stack is not empty
        if (stackPointer >= 0) {

            if (isPartioning == false) {
                high = stack[stackPointer];
                stackPointer--;
                low = stack[stackPointer];
//                stackPointer--;
                arrayIndex = low - 1;
                pivotElement = array[high];
                compareIndex = low;
                isPartioning = true;
            }
  
            // set pivot element at it's proper position
            
            if (compareIndex <= high - 1) {

                if (array[compareIndex] <= pivotElement) {
                    arrayIndex++;
                    swap(arrayIndex, compareIndex);
                }
                
                compareIndex++;
//                return array;
            }
            else {
                swap(arrayIndex+1, high);

                partitionIndex = arrayIndex+1;

                stackPointer--;

                // If there are elements on left side of pivot,
                // then push left side to stack
                if (partitionIndex - 1 > low) {
                    stackPointer++;
                    stack[stackPointer] = low;
                    stackPointer++;
                    stack[stackPointer] = partitionIndex - 1;
                }

                // If there are elements on right side of pivot,
                // then push right side to stack
                if (partitionIndex + 1 < high) {
                    stackPointer++;
                    stack[stackPointer] = partitionIndex + 1;
                    stackPointer++;
                    stack[stackPointer] = high;
                }

                isPartioning = false;
                
            }
    
        }

//        return array;
    }
    
    public void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
//    public void push(int val) {
//        stackPointer++;
//        stack[stackPointer] = val;
//    }

    public int[] getArray() {
        return array;
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

    public int getPartitionIndex() {
        return partitionIndex;
    }
    public void setPartitionIndex(int partitionIndex) {
        this.partitionIndex = partitionIndex;
    }
    
//    public int getLow() {
//        return low;
//    }
//    public void setLow(int low) {
//        this.low = low;
//    }

//    public int getHigh() {
//        return high;
//    }
//    public void setHigh(int high) {
//        this.high = high;
//    }
    
//    public int getSP() {
//        return stackPointer;
//    }
//    public void setSP(int sp) {
//        this.stackPointer = sp;
//    }

//    public boolean getIsPartitioning() {
//        return isPartioning;
//    }
//    public void setIsPartioning(boolean isPartioning) {
//        this.isPartioning = isPartioning;
//    }
}
