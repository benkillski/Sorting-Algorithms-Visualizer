package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

import java.awt.*;
import java.util.concurrent.CountDownLatch;

//TODO: FINISH
public class SleepSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        for(int x : array.getArray())
            new CreateThread(x).start();
    }

    class CreateThread extends Thread
    {
        int value;

        CreateThread(int value)
        {
            this.value = value;
        }

        public void run()
        {
            try
            {
                int sleepingTime = this.value;
                Thread.sleep(1000L * sleepingTime);
                System.out.print(this.value + " ");
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getAlgorithmName() {
        return null;
    }
}
