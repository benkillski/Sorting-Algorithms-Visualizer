package SortingAlgorithmsVisualizer;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 *Class holds all array data and draws graphical visualizations of the array
 * @author Ben Kilkowski
 */
public class ArrayManager extends JPanel
{
    public static final int WINDOW_WIDTH = 1530;
    public static final int WINDOW_HEIGHT = 700;
    private static int columnWidth = 15;         //Width of each graphical array element representation

    private static long milliSecDelay = 25;    //Used to determine the speed at which the visualization is ran

    private int[] array;                  //Array of elements to be sorted
    private final Color[] elementColors;        //Color of each graphical array element representation

    int numOfComparisions;
    int numOfIterations;

    //
    //  Constructor for ArrayManager class, creates and draws array for application start up
    //
    public ArrayManager()
    {
        numOfComparisions = 0;
        numOfIterations = 0;

        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        array = new int[(WINDOW_WIDTH / columnWidth) - 2];
        elementColors = new Color[array.length];
        randomizeArray(array.length);

        setBackground(Color.BLACK);
    }

    //
    //  Generates random elements for the array
    //
    public void randomizeArray(int size)
    {
        array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < array.length - 1; i++)
        {
            array[i] = rand.nextInt(WINDOW_HEIGHT - 50) + 1;
        }
        //System.out.println("SIZE: " + array.length);
        revalidate();
        repaint();
    }

    //
    //  Shuffles the array, causing it to be unsorted again
    //
    public void shuffle()
    {
        Random rand = ThreadLocalRandom.current();
        for(int i = array.length - 1; i > 0; i--)
        {
            numOfComparisions = 0;
            numOfIterations = 0;

            int index = rand.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;

            revalidate();
            repaint();
            sleepForNanoSecs(milliSecDelay * 1000000);
        }
    }

    //
    //  Used to test whether the array was sorted correctly or not
    //
    boolean sortSuccess()
    {
        for(int i = 0; i < array.length - 1; i++)
        {
            if(array[i] > array[i + 1])
            {
                for(int j = 0; i < elementColors.length - 1; i++)
                {
                    elementColors[i] = Color.RED;
                }
                return false;
            }
            elementColors[i] = Color.GREEN;     //Green indicating that the sort was successful

            revalidate();
            repaint();

            sleepForNanoSecs(milliSecDelay * 1000000);
        }
        sleepForNanoSecs(100000 * 1000000);
        Arrays.fill(elementColors, Color.WHITE);

        revalidate();
        repaint();
        return true;
    }

    //
    //  Swaps two array elements and updates it on screen
    //
    public void swap(int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        Arrays.fill(elementColors, Color.WHITE);    //Resets all other elements as white while not being visited
        elementColors[index1] = Color.RED;          //Red marks element as currently being swapped
        elementColors[index2] = Color.RED;

        revalidate();
        repaint();

        sleepForNanoSecs(milliSecDelay * 1000000);
    }

    //
    //  Used for delays between array element changes
    //
    public static void sleepForNanoSecs(long nanoSeconds)
    {
        long timeElapsed;
        final long startTime = System.nanoTime();

        do
        {
            timeElapsed = System.nanoTime() - startTime;
        }
        while(timeElapsed < nanoSeconds);
    }


    //
    //  Handles drawing of the array visualization and is called everytime
    //  there is a change in the array
    //
    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        Main.comparisonsDisplay.setText("Comparisons: " + numOfComparisions);
        Main.iterationsDisplay.setText("Iterations: " + numOfIterations);

        graphics.setColor(Color.WHITE);
        for(int i = 0; i < array.length - 1; i++)
        {
            graphics.setColor(elementColors[i]);
            graphics.fillRect((i * columnWidth) + (columnWidth * 2), WINDOW_HEIGHT, columnWidth, -array[i]);
        }
        graphics.dispose();
    }

    //
    //  Returns the size of the array
    //
    public int getArraySize()
    {
        return array.length;
    }

    //
    //  Returns the array element at the specified index
    //
    public int getArrayValue(int index)
    {
        return array[index];
    }

    //
    //  Sets the array element at the specified index
    //
    public void setArrayValue(int index, int newValue)
    {
        array[index] = newValue;
        Arrays.fill(elementColors, Color.WHITE);
        elementColors[index] = Color.RED;
        revalidate();
        repaint();
        sleepForNanoSecs(milliSecDelay * 1000000);
    }

    //
    //  Returns the whole array
    //
    public int[] getArray()
    {
        return array;
    }

    //
    //  Returns the width of each column
    //
    public int getColumnWidth()
    {
        return columnWidth;
    }

    //
    //  Sets the width of each column
    //
    public void setColumnWidth(int width)
    {
        columnWidth = width;
    }

    //
    //  Returns the current milliSecDelay
    //
    public long getMilliSecDelay()
    {
        return milliSecDelay;
    }

    //
    //  Sets the current milliSecDelay
    //
    public void setMilliSecDelay(long delay)
    {
        milliSecDelay = delay;
    }

    //
    //  Returns the current number of comparisons
    //
    public int getNumOfComparisions()
    {
        return numOfComparisions;
    }

    //
    //  Sets the number of comparisons
    //
    public void setNumOfComparisions(int value)
    {
        numOfComparisions = value;
    }

    //
    //  Returns the current number of iterations
    //
    public int getNumOfIterations()
    {
        return numOfIterations;
    }

    //
    //  Sets the number of iterations
    //
    public void setNumOfIterations(int value)
    {
        numOfIterations = value;
    }
}