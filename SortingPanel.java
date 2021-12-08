package sortingalgorithmvisualizer;

//import java.awt.Color;
//import java.awt.Graphics;
import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
//import javax.sound.sampled.AudioInputStream;
//import javax.sound.sampled.AudioSystem;
//import javax.sound.sampled.Clip;
import javax.sound.sampled.*;
//import javax.swing.JButton;
//import javax.swing.JComboBox;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JTextField;
//import javax.swing.Timer;
import javax.swing.*;

public class SortingPanel extends JPanel {
    
    private static final long serialVersionUID = 1L;
    
    private Random random = new Random();
    private int[] array = new int[50];

    
    JButton startButton = new JButton("Start");
    JButton resetButton = new JButton("Reset");
    JButton bubbleSortButton = new JButton("Bubble Sort");
    JButton selectionSortButton = new JButton("Selection Sort");
    JButton insertionSortButton = new JButton("Insertion Sort");
    JButton quickSortButton = new JButton("Quick Sort");
    JButton linearSearchButton = new JButton("Linear Search");
    JButton binarySearchButton = new JButton("Binary Search");
    
    JTextField arraySizeTextField;
    JComboBox arraySizesComboBox;
    Integer[] availableArraySizesArray;
    
    JTextField searchElementTextField;
    JComboBox searchElementsComboBox;
    Integer[] searchElementsArray;
    
    JTextField delayTextField;
    JComboBox delayComboBox;
    Integer[] delayArray;
    
    private boolean isRunning;
    private boolean isBubbleSort;
    private boolean isSelectionSort;
    private boolean isInsertionSort;
    private boolean isQuickSort;
    private boolean isLinearSearch;
    private boolean isBinarySearch;
    private boolean isSortedArrayGenerated;
    
    private int delay;
    
    File file;
    AudioInputStream audioInputStream;
    Clip clip;
    
    private BubbleSort bubbleSort;
    private SelectionSort selectionSort;
    private InsertionSort insertionSort;
    private QuickSort quickSort;
    private LinearSearch linearSearch;
    private BinarySearch binarySearch;
    
//    Constructor
    public SortingPanel() {
        file = new File("F:\\WORKING TREE\\JAVA PROGRAMMING\\UNI PROJECTS\\SortingAlgorithmVisualizer\\src\\sortingalgorithmvisualizer\\sounds\\arrayElementAccessSound.wav");
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        
        
//        setting size to 25 because default value is 25 and drop will be initialized later
        array = ArrayManager.randomArrayGenerator(25);
        
        bubbleSort = new BubbleSort(array);
        selectionSort = new SelectionSort(array);
        insertionSort = new InsertionSort(array);
        quickSort = new QuickSort(array);
        linearSearch = new LinearSearch(array);
        binarySearch = new BinarySearch(array);
        
        startButton.setBackground(Color.WHITE);
        startButton.setFocusPainted(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    isRunning = true;
                    if(isBubbleSort) {
                        disablingUIElements();
                        bubbleSortAnimate();
                    }
                    else if(isSelectionSort) {
                        disablingUIElements();
                        selectionSortAnimate();
                    }
                    else if(isInsertionSort) {
                        disablingUIElements();
                        insertionSortAnimate();
                    }
                    else if(isQuickSort) {
                        disablingUIElements();
                        quickSortAnimate();
                    }
                    else if(isLinearSearch) {
                        disablingUIElements();
                        linearSearchAnimate();
                    }
                    else if(isBinarySearch) {
                        disablingUIElements();
                        binarySearchAnimate();
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "Select A Sorting Or Searching Algorithm First!",
                                "ERROR",
                                JOptionPane.INFORMATION_MESSAGE);
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
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                setRandomArray();
                isRunning = false;
                
                isBubbleSort = false;
                isSelectionSort = false;
                isInsertionSort = false;
                isQuickSort = false;
                isLinearSearch = false;
                isBinarySearch = false;
                enablingUIElements();
                repaint();
            }
        });
        
        bubbleSortButton.setBackground(Color.WHITE);
        bubbleSortButton.setFocusPainted(false);
        bubbleSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    if(isSortedArrayGenerated) {
                        setRandomArray();
                    }
                    isSelectionSort = false;
                    isInsertionSort = false;
                    isQuickSort = false;
                    isLinearSearch = false;
                    isBinarySearch = false;
                    selectionSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    linearSearchButton.setEnabled(true);
                    binarySearchButton.setEnabled(true);
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
        selectionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    if(isSortedArrayGenerated) {
                        setRandomArray();
                    }
                    isBubbleSort = false;
                    isInsertionSort = false;
                    isQuickSort = false;
                    isLinearSearch = false;
                    isBinarySearch = false;
                    bubbleSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    linearSearchButton.setEnabled(true);
                    binarySearchButton.setEnabled(true);
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
        insertionSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    if(isSortedArrayGenerated) {
                        setRandomArray();
                    }
                    isBubbleSort = false;
                    isSelectionSort = false;
                    isQuickSort = false;
                    isLinearSearch = false;
                    isBinarySearch = false;
                    bubbleSortButton.setEnabled(true);
                    selectionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    linearSearchButton.setEnabled(true);
                    binarySearchButton.setEnabled(true);
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
        quickSortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    if(isSortedArrayGenerated) {
                        setRandomArray();
                    }
                    isBubbleSort = false;
                    isSelectionSort = false;
                    isInsertionSort = false;
                    isLinearSearch = false;
                    isBinarySearch = false;
                    bubbleSortButton.setEnabled(true);
                    selectionSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    linearSearchButton.setEnabled(true);
                    binarySearchButton.setEnabled(true);
                    isQuickSort = true;
                    quickSortButton.setEnabled(false);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        linearSearchButton.setBackground(Color.WHITE);
        linearSearchButton.setFocusPainted(false);
        linearSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    if(isSortedArrayGenerated) {
                        setRandomArray();
                    }
                    isBubbleSort = false;
                    isSelectionSort = false;
                    isInsertionSort = false;
                    isQuickSort = false;
                    isBinarySearch = false;
                    bubbleSortButton.setEnabled(true);
                    selectionSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    binarySearchButton.setEnabled(true);
                    isLinearSearch = true;
                    linearSearchButton.setEnabled(false);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        binarySearchButton.setBackground(Color.WHITE);
        binarySearchButton.setFocusPainted(false);
        binarySearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    if(!isSortedArrayGenerated) {
                        setNormalArray();
                    }
                    isBubbleSort = false;
                    isSelectionSort = false;
                    isInsertionSort = false;
                    isQuickSort = false;
                    isLinearSearch = false;
                    bubbleSortButton.setEnabled(true);
                    selectionSortButton.setEnabled(true);
                    insertionSortButton.setEnabled(true);
                    quickSortButton.setEnabled(true);
                    linearSearchButton.setEnabled(true);
                    isBinarySearch = true;
                    binarySearchButton.setEnabled(false);
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
        
        availableArraySizesArray = setArraySizeComboBox();
        arraySizesComboBox = new JComboBox(availableArraySizesArray);
        arraySizesComboBox.setSelectedIndex(0);
        arraySizesComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    if(isSortedArrayGenerated) {
                        setNormalArray();
                    } else {
                        setRandomArray();
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        searchElementTextField = new JTextField("Search Value");
        searchElementTextField.setBackground(new Color(31,31,31));
        searchElementTextField.setEditable(false);
        searchElementTextField.setFont(startButton.getFont());
        searchElementTextField.setForeground(Color.WHITE);
        searchElementTextField.setHighlighter(null);
        
        searchElementsArray = setSearchElementsComboBox();
        searchElementsComboBox = new JComboBox(searchElementsArray);
        searchElementsComboBox.setSelectedIndex(0);
        searchElementsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                repaint();
            }
        });
        
        delayTextField = new JTextField("Delay (milliseconds)");
        delayTextField.setBackground(new Color(31,31,31));
        delayTextField.setEditable(false);
        delayTextField.setFont(startButton.getFont());
        delayTextField.setForeground(Color.WHITE);
        delayTextField.setHighlighter(null);
        
        delayArray = setDelayComboBox();
        delayComboBox = new JComboBox(delayArray);
        delayComboBox.setSelectedIndex(0);
        delayComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clip.setMicrosecondPosition(0);
                clip.start();
                try {
                    delay = (int)delayComboBox.getSelectedItem();
                    repaint();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        
        delay = 1;
        
        this.add(startButton);
        this.add(resetButton);
        this.add(bubbleSortButton);
        this.add(selectionSortButton);
        this.add(insertionSortButton);
        this.add(quickSortButton);
        
        this.add(arraySizeTextField);
        this.add(arraySizesComboBox);
        
        this.add(searchElementTextField);
        this.add(searchElementsComboBox);
        this.add(linearSearchButton);
        this.add(binarySearchButton);
        
        this.add(delayTextField);
        this.add(delayComboBox);
    }
    
    public void setRandomArray() {
        array = ArrayManager.randomArrayGenerator((int)arraySizesComboBox.getSelectedItem());
        bubbleSort = new BubbleSort(array);
        selectionSort = new SelectionSort(array);
        insertionSort = new InsertionSort(array);
        quickSort = new QuickSort(array);
        linearSearch = new LinearSearch(array);
        binarySearch = new BinarySearch(array);
        isSortedArrayGenerated = false;
        repaint();
    }
    public void setNormalArray() {
        array = ArrayManager.normalArrayGenerator((int)arraySizesComboBox.getSelectedItem());
        bubbleSort = new BubbleSort(array);
        selectionSort = new SelectionSort(array);
        insertionSort = new InsertionSort(array);
        quickSort = new QuickSort(array);
        linearSearch = new LinearSearch(array);
        binarySearch = new BinarySearch(array);
        isSortedArrayGenerated = true;
        repaint();
    }
    
    private Integer[] setArraySizeComboBox() {
        Integer[] temp = new Integer[8];
        int index = 0;
        for(int j=25; j<=500; j++) {
            if(1000%j==0) {
                temp[index] = j;
                index++;
            }
        }
        return temp;
    }
    private Integer[] setSearchElementsComboBox() {
        Integer[] temp = new Integer[550];
        for(int i=0; i<temp.length; i++) {
            temp[i] = i+1;
        }
        return temp;
    }
    private Integer[] setDelayComboBox() {
        Integer[] temp = new Integer[1000];
        for(int i=0; i<temp.length; i++) {
            temp[i] = i+1;
        }
        return temp;
    }
    
    public void disablingUIElements() {
        startButton.setEnabled(false);
        bubbleSortButton.setEnabled(false);
        selectionSortButton.setEnabled(false);
        insertionSortButton.setEnabled(false);
        quickSortButton.setEnabled(false);
        arraySizesComboBox.setEnabled(false);
        searchElementsComboBox.setEnabled(false);
        linearSearchButton.setEnabled(false);
        binarySearchButton.setEnabled(false);
        delayComboBox.setEnabled(false);
    }
    public void enablingUIElements() {
        startButton.setEnabled(true);
        bubbleSortButton.setEnabled(true);
        selectionSortButton.setEnabled(true);
        insertionSortButton.setEnabled(true);
        quickSortButton.setEnabled(true);
        arraySizesComboBox.setEnabled(true);
        searchElementsComboBox.setEnabled(true);
        linearSearchButton.setEnabled(true);
        binarySearchButton.setEnabled(true);
        delayComboBox.setEnabled(true);
    }
    
    public boolean isSorted() {
        for(int i=0; i<array.length-1; i++) {
            if(array[i]>array[i+1]) {
                return false;
            }
        }
        return true;
    }
    
    public void bubbleSortAnimate() {
        bubbleSort.setCompareIndex(0);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
                    bubbleSort.setCompareIndex(Integer.MAX_VALUE);
                    isBubbleSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        bubbleSort.bubbleSortOnlyOneItem();
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
    public void selectionSortAnimate() {
        selectionSort.setArrayIndex(0);
        selectionSort.setMinIndex(selectionSort.getArrayIndex());
        selectionSort.setCompareIndex(selectionSort.getArrayIndex()+1);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
                    selectionSort.setMinIndex(Integer.MAX_VALUE);
                    selectionSort.setCompareIndex(Integer.MAX_VALUE);
                    isSelectionSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        selectionSort.selectionSortOnlyOneItem();
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
    public void insertionSortAnimate() {
        insertionSort.setArrayIndex(1);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
                    insertionSort.setCompareIndex(Integer.MAX_VALUE);
                    isInsertionSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        insertionSort.insertionSortOnlyOneItem();
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
    public void quickSortAnimate() {
        quickSort.setArrayIndex(0);
        quickSort.setCompareIndex(0);
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isSorted() || isRunning==false) {
                    quickSort.setArrayIndex(Integer.MAX_VALUE);
                    quickSort.setCompareIndex(Integer.MAX_VALUE);
                    quickSort.setPartitionIndex(-1);
                    isQuickSort = false;
                    repaint();
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        quickSort.sortOnlyOneItem();
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                }
                repaint();
            }
        });
        timer.start();
    }
    
    public void linearSearchAnimate() {
        linearSearch.setArrayIndex(0);
        linearSearch.setFindX((int)searchElementsComboBox.getSelectedItem());
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(linearSearch.getFounded() || isRunning==false) {
                    linearSearch.setArrayIndex(Integer.MAX_VALUE);
                    linearSearch.setFindX(-1);
                    linearSearch.setFounded(false);
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        linearSearch.linearSearchCheckOneItem();
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }
    
    public void binarySearchAnimate() {
        binarySearch.setStartIndex(0);
        binarySearch.setEndIndex(array.length-1);
        binarySearch.setFindX((int)searchElementsComboBox.getSelectedItem());
//        timer is taking value in milliseconds i.e 1000ms = 1s
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(binarySearch.getFounded() || isRunning==false) {
                    binarySearch.setFindX(-1);
                    binarySearch.setFounded(false);
                    ((Timer)e.getSource()).stop();
                } else {
                    if(isRunning) {
                        binarySearch.binarySearchCheckOneItem();
                        clip.setMicrosecondPosition(0);
                        clip.start();
                    }
                    repaint();
                }
            }
        });
        timer.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(31,31,31));
        
        for(int i=0; i<array.length; i++) {
            
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
                if(i==quickSort.getArrayIndex()) {
                    g.setColor(Color.BLUE);
                }
                if(i==quickSort.getCompareIndex()) {
                    g.setColor(Color.RED);
                }
                if(i==quickSort.getPartitionIndex()) {
                    g.setColor(Color.GREEN);
                }
            }
            
            if(isLinearSearch) {
                if(i==linearSearch.getArrayIndex()) {
                    g.setColor(Color.RED);
                    if(linearSearch.getFounded()) {
                        g.setColor(Color.GREEN);
                    }
                }
            }
            
            if(isBinarySearch) {
                if(i==binarySearch.getStartIndex()) {
                    g.setColor(Color.BLUE);
                }
                if(i==binarySearch.getEndIndex()) {
                    g.setColor(Color.RED);
                }
                if(i==binarySearch.getMidIndex()) {
                        g.setColor(Color.GREEN);
                    if(linearSearch.getFounded()) {
                    }
                }
            }
            
//            g.fillRect(x, y, WIDTH, HEIGHT);
            g.fillRect(100+((1000/array.length)*i), 675-array[i], (1000/array.length)-1, array[i]);
        }
    }
    
    
}
