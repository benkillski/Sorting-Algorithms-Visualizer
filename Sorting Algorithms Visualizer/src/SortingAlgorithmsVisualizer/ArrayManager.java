package SortingAlgorithmsVisualizer;

import SortingAlgorithmsVisualizer.Algorithms.BubbleSort;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ArrayManager extends JPanel
{
    public static final int WINDOW_WIDTH = 1280;
    public static final int WINDOW_HEIGHT = 720;
    private static final int COLUMN_WIDTH = 10;

    private static final long milliSecDelay = 20;

    private final int[] array;
    private final int[] columnColors;

    public ArrayManager()
    {
        setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        array = new int[WINDOW_WIDTH / COLUMN_WIDTH];
        columnColors = new int[WINDOW_WIDTH / COLUMN_WIDTH];
        randomizeArray();

        setBackground(Color.BLACK);
    }

    void randomizeArray()
    {
        Random rand = new Random();
        for(int i = 0; i < array.length - 1; i++)
        {
            array[i] = rand.nextInt(WINDOW_HEIGHT - 1);
        }
    }

    public void swap(int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        columnColors[index1] = 100;
        columnColors[index2] = 100;

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
            int val = columnColors[i] * 2;
            graphics.setColor(new Color(255, 255 - val, 255 - val));
            graphics.fillRect(i * COLUMN_WIDTH, WINDOW_HEIGHT, COLUMN_WIDTH, -array[i]);
            if(columnColors[i] > 0)
            {
                columnColors[i] -= 10;
            }
        }
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
        columnColors[index] = 100;
        repaint();
        sleepForNanoSecs(milliSecDelay * 1000000);
    }

    public int[] getArray()
    {
        return array;
    }
}
