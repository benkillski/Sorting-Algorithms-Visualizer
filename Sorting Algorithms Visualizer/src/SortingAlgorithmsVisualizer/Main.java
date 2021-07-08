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
    JButton bitonicSortButton;
    JButton bogoSortButton;
    JButton brickSortButton;
    JButton bubbleSortButton;
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
        //new CycleSort().runSort(arrayManager);
        //new TimSort().runSort(arrayManager);
        //new CocktailSort().runSort(arrayManager);
        //TODO: MAY NOT DO: new StrandSort().runSort(arrayManager);
        //new BitonicSort().runSort(arrayManager);
        //new PancakeSort().runSort(arrayManager);
        //new BogoSort().runSort(arrayManager);
        //new GnomeSort().runSort(arrayManager);
        //TODO: MAY NOT DO: new SleepSort().runSort(arrayManager);
        //TODO: MAY NOT DO: new StructureSort().runSort(arrayManager);
        //new StoogeSort().runSort(arrayManager);
        //TODO: MAY NOT DO: new TagSort().runSort(arrayManager);
        //TODO: MAY NOT DO: new TreeSort().runSort(arrayManager);
        //TODO: MAY NOT DO: new CartesianTreeSort().runSort(arrayManager);
        //new BrickSort().runSort(arrayManager);

        System.out.print(arrayManager.sortSuccess());
    }

    public static void main(String[] args)
    {
        Main main = new Main();
    }

    private void configInterface()
    {
        sortAlgorithmTypesBar = new JMenuBar();
        window.add(sortAlgorithmTypesBar, BorderLayout.SOUTH);

        bubbleSortButton = new JButton("Bubble");
        bubbleSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(bubbleSortButton);

        selectionSortButton = new JButton("Selection");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Insertion");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Merge");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Heap");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Quick");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Radix");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Counting");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Bucket");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Shell");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Comb");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Pigeonhole");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Cycle");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Tim");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Cocktail");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Bitonic");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Pancake");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Bogo");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Gnome");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Stooge");
        selectionSortButton.addActionListener(this);
        sortAlgorithmTypesBar.add(selectionSortButton);

        selectionSortButton = new JButton("Brick");
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
