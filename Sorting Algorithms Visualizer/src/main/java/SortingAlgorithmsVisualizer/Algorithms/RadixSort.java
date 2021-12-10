package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

import java.util.Arrays;

public class RadixSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        radixSort(array, array.getArraySize());
    }

    private void radixSort(ArrayManager array, int n)
    {
        int max = getMax(array, n);

        for(int exp = 1; max / exp > 0; exp *= 10)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            countSort(array, n, exp);
        }
    }

    private void countSort(ArrayManager array, int n, int exp)
    {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        for(i = 0; i < n; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            count[(array.getArrayValue(i) / exp) % 10]++;
        }

        for(i = 1; i < 10; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            count[i] += count[i - 1];
        }

        for(i = n - 1; i >= 0; i--)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            output[count[(array.getArrayValue(i) / exp) % 10] - 1] = array.getArrayValue(i);
            count[(array.getArrayValue(i) / exp) % 10]--;
        }

        for(i = 0; i < n; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            array.setArrayValue(i, output[i]);
        }
    }

    private int getMax(ArrayManager array, int n)
    {
        int max = array.getArrayValue(0);
        for(int i = 1; i < n; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            if (array.getArrayValue(i) > max)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                max = array.getArrayValue(i);
            }
        }
        return max;
    }

    @Override
    public String getAlgorithmName()
    {
        return "Radix Sort";
    }
}
