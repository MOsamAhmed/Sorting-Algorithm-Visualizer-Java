package sortingalgorithmvisualizer;
//import javax.swing.*;
//import java.awt.*;


import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class MyFrame extends JFrame {
    
    private static final long serialVersionUID = 1L;
    
    private SortingPanel sortingPanel = new SortingPanel();
    
    JButton button;
    ImageIcon img = new ImageIcon("F:\\WORKING TREE\\JAVA PROGRAMMING\\UNI PROJECTS\\SortingAlgorithmVisualizer\\src\\sortingalgorithmvisualizer\\imgs\\icon.png");
    
    public MyFrame() {
        this.setTitle("Sorting Visualizer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.getContentPane().setSize(new Dimension(1200, 600));
        this.getContentPane().setPreferredSize(new Dimension(1200, 675));
        this.getContentPane().add(sortingPanel);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setIconImage(img.getImage());
        this.setVisible(true);
    }
    
//    public SortingPanel getSortingPanel() {
//        return this.sortingPanel;
//    }
    
}
