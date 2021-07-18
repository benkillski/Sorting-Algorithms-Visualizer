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
    public static final int WINDOW_WIDTH = 1520;
    public static final int WINDOW_HEIGHT = 700;
    private static final int COLUMN_WIDTH = 20;         //Width of each graphical array element representation

    private static final long milliSecDelay = 25;       //Used to determine the speed at which the visualization is ran

    private final int[] array;                  //Array of elements to be sorted
    private final Color[] elementColors;        //Color of each graphical array element representation

    //int numOfComparisions;

    //
    //  Constructor for ArrayManager class, creates and draws array for application start up
    //
    public ArrayManager()
    {
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        array = new int[WINDOW_WIDTH / COLUMN_WIDTH - 2];
        elementColors = new Color[array.length];
        randomizeArray();

        setBackground(Color.BLACK);
    }

    //
    //  Generates random elements for the array
    //
    void randomizeArray()
    {
        Random rand = new Random();
        for (int i = 0; i < array.length - 1; i++)
        {
            array[i] = rand.nextInt(WINDOW_HEIGHT - 50);
            revalidate();
            repaint();
        }
    }

    //
    //  Shuffles the array, causing it to be unsorted again
    //
    public void shuffle()
    {
        Random rand = ThreadLocalRandom.current();
        for(int i = array.length - 1; i > 0; i--)
        {
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
    //TODO: Add green color when sort check is successful
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
        Arrays.fill(elementColors, Color.WHITE);

        //numOfComparisions = 0;
        //Main.comparisonsDisplay.setText("Comparisons: " + 0);
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

        graphics.setColor(Color.WHITE);
        for(int i = 0; i < array.length - 1; i++)
        {
            graphics.setColor(elementColors[i]);
            graphics.fillRect((i * COLUMN_WIDTH) + (COLUMN_WIDTH * 2), WINDOW_HEIGHT - 12, COLUMN_WIDTH, -array[i]);
        }
        graphics.dispose();
    }

    //
    //  Returns the size of the array
    //
    public int arrSize()
    {
        return array.length;
    }

    //
    //  Returns the array element at the specified index
    //
    public int getArrValue(int index)
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

    /*public int getNumOfComparisions()
    {
        return numOfComparisions;
    }*/

    /*public void setNumOfComparisions(int value)
    {
        numOfComparisions = value;
    }*/
}
