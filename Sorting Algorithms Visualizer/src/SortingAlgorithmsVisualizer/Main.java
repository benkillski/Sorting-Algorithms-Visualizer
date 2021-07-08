package SortingAlgorithmsVisualizer;

import SortingAlgorithmsVisualizer.Algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main
{
    JMenuBar sortAlgSelectBar;
    JMenuItem selectionSortMenuItem;

    ArrayManager arrayManager;
    ArrayList<SortAlgorithm> algorithmList = new ArrayList<SortAlgorithm>();

    public Main()
    {
        JFrame window = new JFrame("Sorting Algorithms Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setResizable(false);

        arrayManager = new ArrayManager();
        window.add(arrayManager, BorderLayout.CENTER);

        sortAlgSelectBar = new JMenuBar();
        window.add(sortAlgSelectBar, BorderLayout.SOUTH);

        selectionSortMenuItem = new JMenuItem("Selection Sort");
        //selectionSortMenuItem.addActionListener(this);
        sortAlgSelectBar.add(selectionSortMenuItem);

        window.pack();
        window.setVisible(true);


        //new SelectionSort().runSort(arrayManager);
        //new BubbleSort().runSort(arrayManager);
        //new InsertionSort().runSort(arrayManager);
        //new MergeSort().runSort(arrayManager);
        //new HeapSort().runSort(arrayManager);
        new QuickSort().runSort(arrayManager);

    }

    public static void main(String[] args)
    {
        Main main = new Main();
    }

    /*@Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == selectionSortMenuItem)
            new SelectionSort().runSort(arrayManager);
    }*/
}
