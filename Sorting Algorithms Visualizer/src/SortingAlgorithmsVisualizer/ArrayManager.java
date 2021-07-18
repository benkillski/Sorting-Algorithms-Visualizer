package SortingAlgorithmsVisualizer;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayManager extends JPanel {
    public static final int WINDOW_WIDTH = 1525;
    public static final int WINDOW_HEIGHT = 700;
    private static final int COLUMN_WIDTH = 8;

    private static final long milliSecDelay = 25;

    private final int[] array;
    private final Color[] elementColors;

    int numOfComparisions;

    public ArrayManager()
    {
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        array = new int[WINDOW_WIDTH / COLUMN_WIDTH];
        elementColors = new Color[WINDOW_WIDTH / COLUMN_WIDTH];
        randomizeArray();

        setBackground(Color.BLACK);
    }

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
            elementColors[i] = Color.GREEN;

            revalidate();
            repaint();

            sleepForNanoSecs(milliSecDelay * 1000000);
        }
        Arrays.fill(elementColors, Color.WHITE);

        numOfComparisions = 0;
        Main.comparisonsDisplay.setText("Comparisons: " + 0);
        revalidate();
        repaint();
        return true;
    }

    public void swap(int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        Arrays.fill(elementColors, Color.WHITE);
        elementColors[index1] = Color.RED;
        elementColors[index2] = Color.RED;

        revalidate();
        repaint();

        sleepForNanoSecs(milliSecDelay * 1000000);
    }

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


    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D graphics = (Graphics2D) g;
        super.paintComponent(graphics);

        graphics.setColor(Color.WHITE);
        for(int i = 0; i < array.length - 1; i++)
        {
            graphics.setColor(elementColors[i]);
            graphics.fillRect(i * COLUMN_WIDTH, WINDOW_HEIGHT, COLUMN_WIDTH, -array[i]);
        }

        graphics.dispose();
    }

    public int arrSize()
    {
        return array.length;
    }

    public int getArrValue(int index)
    {
        return array[index];
    }

    public void setArrayValue(int index, int newValue)
    {
        array[index] = newValue;
        Arrays.fill(elementColors, Color.WHITE);
        elementColors[index] = Color.RED;
        revalidate();
        repaint();
        sleepForNanoSecs(milliSecDelay * 1000000);
    }

    public int[] getArray()
    {
        return array;
    }

    public int getNumOfComparisions()
    {
        return numOfComparisions;
    }

    public void setNumOfComparisions(int value)
    {
        numOfComparisions = value;
    }
}
