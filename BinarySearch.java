package sortingalgorithmvisualizer;

public class BinarySearch {
    private int findX;
    private int arrayIndex;
    private boolean founded;
    private int[] array;
    
    public BinarySearch(int[] array) {
        findX = -1;
        arrayIndex = Integer.MAX_VALUE;
        founded = false;
        this.array = array;
    }
    
    public void checkOnlyOneItem() {
        if(arrayIndex>=array.length) {
            founded = true;
        }
        else if(findX==array[arrayIndex]) {
//            System.out.println(findX);
//            System.out.println(array[arrayIndex]);
            founded = true;
        }
        else {
            arrayIndex++;
        }
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
