package SortingAlgorithmsVisualizer;

import SortingAlgorithmsVisualizer.Algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener
{
    JFrame window;

    JMenuBar sortAlgorithmTypesBar;
    JButton bubbleSortButton;
    JButton selectionSortButton;
    JButton sortButton;

    ArrayManager arrayManager;

    SortAlgorithm algorithm;

    public Main()
    {
        window = new JFrame("Sorting Algorithms Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setResizable(false);

        arrayManager = new ArrayManager();
        window.add(arrayManager, BorderLayout.CENTER);

        //configInterface();

        window.pack();
        window.setVisible(true);


        //new SelectionSort().runSort(arrayManager);
        //new BubbleSort().runSort(arrayManager);
        //new InsertionSort().runSort(arrayManager);
        //new MergeSort().runSort(arrayManager);
        //new HeapSort().runSort(arrayManager);
        //new QuickSort().runSort(arrayManager);
        //new RadixSort().runSort(arrayManager);
        //new CountingSort().runSort(arrayManager);
        //new BucketSort().runSort(arrayManager);
        //new ShellSort().runSort(arrayManager);
        //new CombSort().runSort(arrayManager);
        //new PigeonholeSort().runSort(arrayManager);
        new CycleSort().runSort(arrayManager);

    }

    public static void main(String[] args)
    {
        Main main = new Main();
    }

    private void configInterface()
    {
        sortAlgorithmTypesBar = new JMenuBar();
        window.add(sortAlgorithmTypesBar, BorderLayout.SOUTH);

        bubbleSortButton = new JButton("Bubble Sort");
        bubbleSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(bubbleSortButton);

        selectionSortButton = new JButton("Selection Sort");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        sortButton = new JButton("SORT");
        sortButton.addActionListener(this);
        window.add(sortButton, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == bubbleSortButton)
        {
            setAlorithm(new BubbleSort());
        }
        else if(actionEvent.getSource() == selectionSortButton)
        {
            setAlorithm(new SelectionSort());
        }
        else if(actionEvent.getSource() == sortButton)
        {
            algorithm.runSort(arrayManager);
        }
    }

    public void setAlorithm(SortAlgorithm algorithm)
    {
        this.algorithm = algorithm;
    }
}
