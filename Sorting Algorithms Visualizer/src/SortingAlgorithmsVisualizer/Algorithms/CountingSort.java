package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

import java.util.Arrays;

public class CountingSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int max = Arrays.stream(array.getArray()).max().getAsInt();
        int min = Arrays.stream(array.getArray()).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[array.getArraySize()];
        for (int i = 0; i < array.getArraySize(); i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            count[array.getArrayValue(i) - min]++;
        }

        for (int i = 1; i < count.length; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            count[i] += count[i - 1];
        }

        for (int i = array.getArraySize() - 1; i >= 0; i--)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            output[count[array.getArrayValue(i) - min] - 1] = array.getArrayValue(i);
            count[array.getArrayValue(i) - min]--;
        }

        for (int i = 0; i < array.getArraySize(); i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            array.setArrayValue(i, output[i]);
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Counting Sort";
    }
}
