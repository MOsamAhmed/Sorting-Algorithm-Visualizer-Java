package sortingalgorithmvisualizer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class SortingPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    private Random random = new Random();
    private int[] array = new int[50];
//    private int arrayIndex;
//    private int bubbleSortCompareIndex;
//    private int selectionSortMinIndex = Integer.MAX_VALUE;
//    private int selectionSortCompareIndex = Integer.MAX_VALUE;
    
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JButton bubbleSortButton = new JButton("Bubble Sort");
    JButton selectionSortButton = new JButton("Selection Sort");
    JButton insertionSortButton = new JButton("Insertion Sort");
    JButton quickSortButton = new JButton("Quick Sort");
    
    JTextField arraySizeTextField;
    JComboBox arraySizesComboBox;
    Integer[] availableArraySizes;
    
    private boolean isRunning;
    private boolean isBubbleSort;
    private boolean isSelectionSort;
    private boolean isInsertionSort;
    private boolean isQuickSort;
    
    private BubbleSort bubbleSort;
    private SelectionSort selectionSort;
    private InsertionSort insertionSort;
    private QuickSort quickSort;
    
//    Constructor
    public SortingPanel() {
//        setting size to 25 because default value is 25 and drop will be initialized later
        array = ArrayManager.randomArrayGenerator(25);
//        this.setArray();

//        arrayIndex = 0;
//        bubbleSortCompareIndex = Integer.MAX_VALUE;
        
        bubbleSort = new BubbleSort(array);
        selectionSort = new SelectionSort(array);
        insertionSort = new InsertionSort(array);
        quickSort = new QuickSort(array);
        
        startButton.setBackground(Color.WHITE);
        startButton.setFocusPainted(false);
//        when border paint is set to true it shows a mouse hover action
//        startButton.setBorderPainted(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    isRunning = true;
                    if(isBubbleSort) {
                        disablingButtons();
                        bubbleSortAnimate();
                    }
                    else if(isSelectionSort) {
                        disablingButtons();
                        selectionSortAnimate();
                    }
                    else if(isInsertionSort) {
                        disablingButtons();
                        insertionSortAnimate();
                    }
                    else if(isQuickSort) {
                        disablingButtons();
                        quickSortAnimate();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Select a sorting algorithm first!", "Error", JOptionPane.INFORMATION_MESSAGE);
//                        JOptionPane.showMessageDialog(startButton, e, TOOL_TIP_TEXT_KEY, HEIGHT);
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        resetButton.setBackground(Color.WHITE);
        resetButton.setFocusPainted(false);
//        resetButton.setBorderPainted(false);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                array = ArrayManager.randomArrayGenerator((int)arraySizesComboBox.getSelectedItem());
                bubbleSort = new BubbleSort(array);
                selectionSort = new SelectionSort(array);
                insertionSort = new InsertionSort(array);
                quickSort = new QuickSort(array);
//                arrayIndex = 0;
//                bubbleSortCompareIndex = Integer.MAX_VALUE;
//                selectionSortMinIndex = Integer.MAX_VALUE;
//                selectionSortCompareIndex = Integer.MAX_VALUE;
//                setArray();
                isRunning = false;
                
                isBubbleSort = false;
                isSelectionSort = false;
                isInsertionSort = false;
                isQuickSort = false;
                enablingButtons();
                repaint();
            }
        });
        
        bubbleSortButton.setBackground(Color.WHITE);
        bubbleSortButton.setFocusPainted(false);
//        bubbleSortButton.setBorderPainted(false);
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    isSelectionSort = false;
                    isInsertionSort = false;
                    isQuickSort = false;
                    selectionSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    isBubbleSort = true;
                    bubbleSortButton.setEnabled(false);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        selectionSortButton.setBackground(Color.WHITE);
        selectionSortButton.setFocusPainted(false);
//        selectionSortButton.setBorderPainted(false);
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    isBubbleSort = false;
                    isInsertionSort = false;
                    isQuickSort = false;
                    bubbleSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    isSelectionSort = true;
                    selectionSortButton.setEnabled(false);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        insertionSortButton.setBackground(Color.WHITE);
        insertionSortButton.setFocusPainted(false);
//        insertionSortButton.setBorderPainted(false);
        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    isBubbleSort = false;
                    isSelectionSort = false;
                    isQuickSort = false;
                    bubbleSortButton.setEnabled(true);
                    selectionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    isInsertionSort = true;
                    insertionSortButton.setEnabled(false);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        quickSortButton.setBackground(Color.WHITE);
        quickSortButton.setFocusPainted(false);
//        quickSortButton.setBorderPainted(false);
        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    isBubbleSort = false;
                    isSelectionSort = false;
                    isInsertionSort = false;
                    bubbleSortButton.setEnabled(true);
                    selectionSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    isQuickSort = true;
                    quickSortButton.setEnabled(false);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        arraySizeTextField = new JTextField("Set Array Size");
        arraySizeTextField.setBackground(new Color(31,31,31));
        arraySizeTextField.setEditable(false);
        arraySizeTextField.setFont(startButton.getFont());
        arraySizeTextField.setForeground(Color.WHITE);
        arraySizeTextField.setHighlighter(null);
        
        availableArraySizes = setArraySizeComboBox();
        arraySizesComboBox = new JComboBox(availableArraySizes);
        arraySizesComboBox.setSelectedIndex(0);
        arraySizesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    array = ArrayManager.randomArrayGenerator((int)arraySizesComboBox.getSelectedItem());
                    
                    bubbleSort = new BubbleSort(array);
                    selectionSort = new SelectionSort(array);
                    insertionSort = new InsertionSort(array);
                    quickSort = new QuickSort(array);
                    repaint();
//                    System.out.println(arraySizesComboBox.getSelectedItem());
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        this.add(startButton);
        this.add(resetButton);
        this.add(bubbleSortButton);
        this.add(selectionSortButton);
        this.add(insertionSortButton);
        this.add(quickSortButton);
        this.add(arraySizeTextField);
        this.add(arraySizesComboBox);
//        System.out.println(
//                startButton.getX() +" "
//                + startButton.getX() +" "
//                + startButton.getWidth() +" "
//                + startButton.getHeight()
//        );
        
    }
    
//    not being used currently
    public int[] getArray() {
        return this.array;
    }
    
//    not being used currently
    public void setArray() {
        for(int i=0; i<this.array.length; i++) {
            this.array[i] = random.nextInt(510)+40;
        }
    }
    
    private Integer[] setArraySizeComboBox() {
        Integer[] temp = new Integer[8];
        int index = 0;
        for(int j=25; j<=500; j++) {
            if(1000%j==0) {
                temp[index] = j;
                index++;
//                System.out.println(j+" ");
            }
        }
        return temp;
//        System.out.println(num);
    }
    
    public void disablingButtons() {
        startButton.setEnabled(false);
        bubbleSortButton.setEnabled(false);
        selectionSortButton.setEnabled(false);
        insertionSortButton.setEnabled(false);
        quickSortButton.setEnabled(false);
        arraySizesComboBox.setEnabled(false);
    }
    public void enablingButtons() {
        startButton.setEnabled(true);
        bubbleSortButton.setEnabled(true);
        selectionSortButton.setEnabled(true);
        insertionSortButton.setEnabled(true);
        quickSortButton.setEnabled(true);
        arraySizesComboBox.setEnabled(true);
    }
    
    public boolean isSorted() {
        for(int i=0; i<array.length-1; i++) {
            if(array[i]>array[i+1]) {
                return false;
            }
        }
        return true;
    }
    
//    public void bubbleSortOnlyOneItem() {
////        inside nested loop
//        if(array[bubbleSortCompareIndex]>array[bubbleSortCompareIndex+1]) {
//            int temp = array[bubbleSortCompareIndex];
//            array[bubbleSortCompareIndex] = array[bubbleSortCompareIndex+1];
//            array[bubbleSortCompareIndex+1] = temp;
//        }
//        
////        checking if nested loop ended and also incrementing nested loop pointer
//        if((bubbleSortCompareIndex+1) < (array.length-arrayIndex-1)) {
//            bubbleSortCompareIndex++;
//        }
//        
////        nested loop ended and incrementing outer loop
//        else {
//            arrayIndex++;
//            bubbleSortCompareIndex = 0;
//        }
//    }
    
    public void bubbleSortAnimate() {
//        bubbleSortCompareIndex = 0;
        bubbleSort.setCompareIndex(0);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
//                    bubbleSortCompareIndex = Integer.MAX_VALUE;
                    bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                    isBubbleSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        bubbleSort.bubbleSortOnlyOneItem();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
//    public void selectionSortOnlyOneItem() {
////        inside nested loop
//        if(array[selectionSortCompareIndex]<array[selectionSortMinIndex]) {
//            selectionSortMinIndex = selectionSortCompareIndex;
//        }
//        
////        checking if nested loop ended and also incrementing nested loop pointer
//        if((selectionSortCompareIndex) < (array.length-1)) {
//            selectionSortCompareIndex++;
//        }
//        
////        nested loop ended and incrementing outer loop
//        else {
//            int temp = array[selectionSortMinIndex];
//            array[selectionSortMinIndex] = array[arrayIndex];
//            array[arrayIndex] = temp;
//            arrayIndex++;
//            selectionSortMinIndex = arrayIndex;
//            selectionSortCompareIndex = arrayIndex+1;
//        }
//    }
    
    public void selectionSortAnimate() {
//        selectionSortMinIndex = arrayIndex;
//        selectionSortCompareIndex = arrayIndex+1;
        selectionSort.setArrayIndex(0);
        selectionSort.setMinIndex(selectionSort.getArrayIndex());
        selectionSort.setCompareIndex(selectionSort.getArrayIndex()+1);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
//                    selectionSortMinIndex = Integer.MAX_VALUE;
//                    selectionSortCompareIndex = Integer.MAX_VALUE;
                    selectionSort.setMinIndex(Integer.MAX_VALUE);
                    selectionSort.setCompareIndex(Integer.MAX_VALUE);
                    isSelectionSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        selectionSort.selectionSortOnlyOneItem();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
    public void insertionSortAnimate() {
        insertionSort.setArrayIndex(1);
//        insertionSort.setMinIndex(insertionSort.getArrayIndex());
//        insertionSort.setCompareIndex(insertionSort.getArrayIndex()+1);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
//                    selectionSortMinIndex = Integer.MAX_VALUE;
//                    selectionSortCompareIndex = Integer.MAX_VALUE;
//                    insertionSort.setMinIndex(Integer.MAX_VALUE);
                    insertionSort.setCompareIndex(Integer.MAX_VALUE);
                    isInsertionSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        insertionSort.insertionSortOnlyOneItem();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
    public void quickSortAnimate() {
//        quickSort.setArrayIndex(0);
        quickSort.setPivotIndex(0);
        quickSort.setStartIndex(quickSort.getPivotIndex()+1);
        quickSort.setEndIndex(quickSort.getArray().length-1);
//        quickSort.setCompareIndex(quickSort.getArrayIndex()+1);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
//                    selectionSortMinIndex = Integer.MAX_VALUE;
//                    selectionSortCompareIndex = Integer.MAX_VALUE;
                    quickSort.setPivotIndex(Integer.MAX_VALUE);
                    quickSort.setStartIndex(Integer.MAX_VALUE);
                    quickSort.setEndIndex(Integer.MAX_VALUE);
//                    quickSort.setCompareIndex(Integer.MAX_VALUE);
                    isQuickSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        quickSort.selectionSortOnlyOneItem();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
//    public void bubbleSortAnimate() {
//        bubbleSortCompareIndex = 0;
////        timer is taking value in milliseconds i.e 1000ms = 1s
//        Timer.
//        Timer timer = new Timer(100, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int temp;
//                for(int i=0; i<array.length-1; i++) {
//                    for(int bubbleSortCompareIndex=0; bubbleSortCompareIndex<array.length-1-i; bubbleSortCompareIndex++) {
//                        if(array[bubbleSortCompareIndex]>array[bubbleSortCompareIndex+1]) {
//                            temp = array[bubbleSortCompareIndex];
//                            array[bubbleSortCompareIndex] = array[bubbleSortCompareIndex+1];
//                            array[bubbleSortCompareIndex+1] = temp;
//                        }
//                    }
//                    repaint();
//                }
//            }
//        });
//        timer.start();
//    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(31,31,31));
        
        for(int i=0; i<array.length; i++) {
            
//            if(i==arrayIndex) {
//                g.setColor(Color.GREEN);
//            } else {
//                g.setColor(new Color(223,223,223));
//            }

//            Default color (grey)
            g.setColor(new Color(223,223,223));
            
            if(isBubbleSort) {
                if(i==bubbleSort.getCompareIndex() || i==bubbleSort.getCompareIndex()+1) {
                    g.setColor(Color.RED);
                }
            }
            
            if(isSelectionSort) {
                if(i==selectionSort.getArrayIndex()) {
                    g.setColor(Color.GREEN);
                }
                if(i==selectionSort.getCompareIndex() || i==selectionSort.getMinIndex()) {
                    g.setColor(Color.RED);
                }
            }
            
            if(isInsertionSort) {
                if(i==insertionSort.getArrayIndex()) {
                    g.setColor(Color.GREEN);
                }
                if(i==insertionSort.getCompareIndex() || i==insertionSort.getCompareIndex()+1) {
                    g.setColor(Color.RED);
                }
            }
            
            if(isQuickSort) {
                if(i==quickSort.getPivotIndex()) {
                    g.setColor(Color.GREEN);
                }
                if(i==quickSort.getStartIndex()) {
                    g.setColor(Color.BLUE);
                }
                if(i==quickSort.getEndIndex()) {
                    g.setColor(Color.RED);
                }
//                if(i==insertionSort.getCompareIndex() || i==insertionSort.getCompareIndex()+1) {
//                    g.setColor(Color.RED);
//                }
            }
            
//            g.fillRect(i*15, 600-array[i], 14, array[i]);
//            g.fillRect(i, i, WIDTH, HEIGHT);
            g.fillRect(100+((1000/array.length)*i), 675-array[i], (1000/array.length)-1, array[i]);
        }
    }
    
    
}
