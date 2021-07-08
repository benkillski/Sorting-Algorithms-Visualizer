package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RadixSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        radixSort(array, array.arrSize());
    }

    private void radixSort(ArrayManager array, int n)
    {
        int max = getMax(array, n);

        for(int exp = 1; max / exp > 0; exp *= 10)
            countSort(array, n, exp);
    }

    private void countSort(ArrayManager array, int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for(i = 0; i < n; i++)
            count[(array.getArrValue(i) / exp) % 10]++;

        for(i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for(i = n - 1; i >= 0; i--)
        {
            output[count[(array.getArrValue(i) / exp) % 10] - 1] = array.getArrValue(i);
            count[(array.getArrValue(i) / exp) % 10]--;
        }

        for(i = 0; i < n; i++)
            array.setArrayValue(i, output[i]);
    }

    private int getMax(ArrayManager array, int n)
    {
        int max = array.getArrValue(0);
        for(int i = 1; i < n; i++) {
            if (array.getArrValue(i) > max)
                max = array.getArrValue(i);
        }
        return max;
    }

    @Override
    public String algorithmName()
    {
        return "Radix";
    }
}
