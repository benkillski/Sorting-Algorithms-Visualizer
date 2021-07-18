package SortingAlgorithmsVisualizer;

import SortingAlgorithmsVisualizer.Algorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Main class that sets up the JFrame and all UI elements
 * @author Ben Kilkowski
 */
public class Main implements ActionListener
{
    private final JFrame window;    //JFrame object that is the core of all UI components.
    private JPanel statBar;         //JPanel that displays and tracks information and data for each algorithm

    JLabel algorithmDisplay;        //JLabel that holds the name of the selected algorithm
    //public static JLabel comparisonsDisplay;

    //JButton components for UI
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

    ArrayManager arrayManager;          //ArrayManager object that holds data for the array. It's also where the visualization is drawn.
    SortAlgorithm selectedAlgorithm;    //Holds the SortAlgorithm object for the selected array

    Executor executor;                  //Object that reuses the same thread for sorting operations
    Runnable sortRunnable;              //Runnable interface object that calls methods that involve sorting and redrawing graphics

    private boolean canSort = true;     //Determines whether user can sort the array. Used to prevent the creation of unneeded threads.

    //
    //Constructor for Main class, instantiates all JFrame and JFrame component objects
    //
    public Main()
    {
        //JFrame and JFrame component initialization
        window = new JFrame("Sorting Algorithms Visualizer");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());
        window.setResizable(false);

        //ArrayManager initialization
        arrayManager = new ArrayManager();
        arrayManager.setLayout(new BorderLayout());
        window.add(arrayManager, BorderLayout.CENTER);

        //Initializes all JButtons for UI
        configUI();

        window.pack();
        window.setVisible(true);

        //Default algorithm upon program execution
        selectedAlgorithm = new BubbleSort();
        algorithmDisplay.setText(selectedAlgorithm.algorithmName());

        //Initialization for the sort logic thread
        executor = Executors.newSingleThreadExecutor();
        sortRunnable = () ->
        {
            selectedAlgorithm.runSort(arrayManager);            //Sorts array and draws visualization
            System.out.println(arrayManager.sortSuccess());     //Test if array was sorted corrected
            arrayManager.shuffle();                             //Shuffles the array and redraws it
            canSort = true;                                     //Allows array to be sorted again
        };
    }

    public static void main(String[] args)
    {
        Main main = new Main();     //Entry point to the program
    }

    //Instantiates and connects all buttons and UI elements to the JFrame
    //TODO: Finish UI Configuration
    private void configUI()
    {
        //Stat bar instantiation
        statBar = new JPanel();
        statBar.setBackground(Color.BLACK);
        window.add(statBar, BorderLayout.NORTH);

        //Algorithm name display JLabel initialization
        algorithmDisplay = new JLabel();
        algorithmDisplay.setForeground(Color.WHITE);
        algorithmDisplay.setFont(new Font(algorithmDisplay.getFont().getName(), Font.PLAIN, 25));
        statBar.add(algorithmDisplay);

        //Spacing for statBar items
        JLabel gap = new JLabel("                              ");
        statBar.add(gap);

        /*comparisonsDisplay = new JLabel("Comparisons: " + arrayManager.getNumOfComparisions());
        comparisonsDisplay.setForeground(Color.WHITE);
        comparisonsDisplay.setFont(new Font(comparisonsDisplay.getFont().getName(), Font.PLAIN, 25));
        statBar.add(comparisonsDisplay);*/

        sortAlgorithmTypesBar = new JMenuBar();
        window.setJMenuBar(sortAlgorithmTypesBar);

        //JButton instantiations
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
        window.add(sortButton, BorderLayout.SOUTH);
    }

    @Override
    //
    //  Listener method for all UI buttons
    //
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
        else if(actionEvent.getSource() == radixSortButton)
        {
            selectedAlgorithm = new RadixSort();
        }
        else if(actionEvent.getSource() == countingSortButton)
        {
            selectedAlgorithm = new CountingSort();
        }
        else if(actionEvent.getSource() == bucketSortButton)
        {
            selectedAlgorithm = new BucketSort();
        }
        else if(actionEvent.getSource() == shellSortButton)
        {
            selectedAlgorithm = new ShellSort();
        }
        else if(actionEvent.getSource() == combSortButton)
        {
            selectedAlgorithm = new CombSort();
        }
        else if(actionEvent.getSource() == pigeonholeSortButton)
        {
            selectedAlgorithm = new PigeonholeSort();
        }
        else if(actionEvent.getSource() == cycleSortButton)
        {
            selectedAlgorithm = new CycleSort();
        }
        else if(actionEvent.getSource() == timSortButton)
        {
            selectedAlgorithm = new TimSort();
        }
        else if(actionEvent.getSource() == cocktailSortButton)
        {
            selectedAlgorithm = new CocktailSort();
        }
        else if(actionEvent.getSource() == bitonicSortButton)
        {
            selectedAlgorithm = new BitonicSort();
        }
        else if(actionEvent.getSource() == pancakeSortButton)
        {
            selectedAlgorithm = new PancakeSort();
        }
        else if(actionEvent.getSource() == bogoSortButton)
        {
            selectedAlgorithm = new BogoSort();
        }
        else if(actionEvent.getSource() == gnomeSortButton)
        {
            selectedAlgorithm = new GnomeSort();
        }
        else if(actionEvent.getSource() == stoogeSortButton)
        {
            selectedAlgorithm = new StoogeSort();
        }
        else if(actionEvent.getSource() == brickSortButton)
        {
            selectedAlgorithm = new BrickSort();
        }
        else if(actionEvent.getSource() == sortButton && canSort)
        {
            canSort = false;                    //Prevents user from sorting while a sort is in progress
            executor.execute(sortRunnable);     //Starts a thread for sorting, bypassing EDT thread
        }
        algorithmDisplay.setText(selectedAlgorithm.algorithmName());    //Changes the algorithm name that is displayed on the stat bar
        arrayManager.repaint();
    }

    /*public void setComparisonDisplay(int value)
    {
        comparisonsDisplay.setText("Comparision " + value);
    }*/
}
