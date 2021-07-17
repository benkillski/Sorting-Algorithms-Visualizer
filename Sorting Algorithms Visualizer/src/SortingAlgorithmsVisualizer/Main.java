package SortingAlgorithmsVisualizer;

import SortingAlgorithmsVisualizer.Algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main implements ActionListener
{
    private final JFrame window;

    JMenuBar sortAlgorithmTypesBar;
    JButton bitonicSortButton;
    JButton bogoSortButton;
    JButton brickSortButton;
    JButton bubbleSortButton;
    JButton bucketSortButton;
    JButton cocktailSortButton;
    JButton combSortButton;
    JButton countingSortButton;
    JButton cycleSortButton;
    JButton gnomeSortButton;
    JButton heapSortButton;
    JButton insertionSortButton;
    JButton mergeSortButton;
    JButton pancakeSortButton;
    JButton pigeonholeSortButton;
    JButton quickSortButton;
    JButton radixSortButton;
    JButton selectionSortButton;
    JButton shellSortButton;
    JButton stoogeSortButton;
    JButton timSortButton;

    JButton sortButton;

    ArrayManager arrayManager;
    SortAlgorithm selectedAlgorithm;

    Executor executor;
    Thread antiEDT;
    Runnable sortRunnable;

    private boolean canSort = true;

    public Main()
    {
        //JFrame and JFrame component initialization
        window = new JFrame("Sorting Algorithms Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setResizable(false);

        arrayManager = new ArrayManager();
        window.add(arrayManager, BorderLayout.CENTER);

        configUI();

        window.pack();
        window.setVisible(true);

        executor = Executors.newSingleThreadExecutor();
        sortRunnable = () ->
        {
            selectedAlgorithm.runSort(arrayManager);
            System.out.println(arrayManager.sortSuccess());
            arrayManager.shuffle();
            canSort = true;
        };
    }

    public static void main(String[] args)
    {
        Main main = new Main();
    }

    //TODO: Finish UI Configuration
    private void configUI()
    {
        sortAlgorithmTypesBar = new JMenuBar();
        window.add(sortAlgorithmTypesBar, BorderLayout.SOUTH);

        bubbleSortButton = new JButton("Bubble");
        bubbleSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(bubbleSortButton);

        selectionSortButton = new JButton("Selection");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        insertionSortButton = new JButton("Insertion");
        insertionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(insertionSortButton);

        mergeSortButton = new JButton("Merge");
        mergeSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(mergeSortButton);

        heapSortButton = new JButton("Heap");
        heapSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(heapSortButton);

        quickSortButton = new JButton("Quick");
        quickSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(quickSortButton);

        radixSortButton = new JButton("Radix");
        radixSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(radixSortButton);

        countingSortButton = new JButton("Counting");
        countingSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(countingSortButton);

        bucketSortButton = new JButton("Bucket");
        bucketSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(bucketSortButton);

        shellSortButton = new JButton("Shell");
        shellSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(shellSortButton);

        combSortButton = new JButton("Comb");
        combSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(combSortButton);

        pigeonholeSortButton = new JButton("Pigeonhole");
        pigeonholeSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(pigeonholeSortButton);

        cycleSortButton = new JButton("Cycle");
        cycleSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(cycleSortButton);

        timSortButton = new JButton("Tim");
        timSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(timSortButton);

        cocktailSortButton = new JButton("Cocktail");
        cocktailSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(cocktailSortButton);

        bitonicSortButton = new JButton("Bitonic");
        bitonicSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(bitonicSortButton);

        pancakeSortButton = new JButton("Pancake");
        pancakeSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(pancakeSortButton);

        bogoSortButton = new JButton("Bogo");
        bogoSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(bogoSortButton);

        gnomeSortButton = new JButton("Gnome");
        gnomeSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(gnomeSortButton);

        stoogeSortButton = new JButton("Stooge");
        stoogeSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(stoogeSortButton);

        brickSortButton = new JButton("Brick");
        brickSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(brickSortButton);

        sortButton = new JButton("SORT");
        sortButton.addActionListener(this);
        window.add(sortButton, BorderLayout.NORTH);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if(actionEvent.getSource() == bubbleSortButton)
        {
            selectedAlgorithm = new BubbleSort();
        }
        else if(actionEvent.getSource() == selectionSortButton)
        {
            selectedAlgorithm = new SelectionSort();
        }
        else if(actionEvent.getSource() == insertionSortButton)
        {
            selectedAlgorithm = new InsertionSort();
        }
        else if(actionEvent.getSource() == mergeSortButton)
        {
            selectedAlgorithm = new MergeSort();
        }
        else if(actionEvent.getSource() == heapSortButton)
        {
            selectedAlgorithm = new HeapSort();
        }
        else if(actionEvent.getSource() == quickSortButton)
        {
            selectedAlgorithm = new QuickSort();
        }
        else if(actionEvent.getSource() == sortButton && canSort)
        {
            canSort = false;
            //antiEDT = new Thread(sortRunnable);
            //antiEDT.start();
            executor.execute(sortRunnable);
        }
    }
}
