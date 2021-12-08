package sortingalgorithmvisualizer;

public class BinarySearch {
    private int findX;
    private int startIndex;
    private int endIndex;
    private int midIndex;
    private boolean founded;
    private int[] array;
    
    public BinarySearch(int[] array) {
        findX = -1;
        startIndex = Integer.MAX_VALUE;
        endIndex = Integer.MAX_VALUE;
        midIndex = Integer.MAX_VALUE;
        founded = false;
        this.array = array;
    }
    
    public void binarySearchCheckOneItem() {
        midIndex = (startIndex+endIndex)/2;
        if(startIndex<=endIndex) {
            if(findX==array[midIndex]) {
                founded = true;
            }
            else if(array[midIndex]<findX) {
                startIndex = midIndex + 1;
            }
            else {
                endIndex = midIndex - 1;
            }
        }
        else {
            startIndex = Integer.MAX_VALUE;
            endIndex = Integer.MAX_VALUE;
            midIndex = Integer.MAX_VALUE;
            founded = true;
        }
    }
    
    public void setArray(int[] array) {
        this.array = array;
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
    
    public int getMidIndex() {
        return midIndex;
    }
    public void setMidIndex(int midIndex) {
        this.midIndex = midIndex;
    }
    
    public int getFindX() {
        return findX;
    }
    public void setFindX(int findX) {
        this.findX = findX;
    }
    
    public boolean getFounded() {
        return founded;
    }
    public void setFounded(boolean founded) {
        this.founded = founded;
    }
    
}
