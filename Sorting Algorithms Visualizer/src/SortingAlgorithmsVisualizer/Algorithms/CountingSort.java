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
        int output[] = new int[array.arrSize()];
        for (int i = 0; i < array.arrSize(); i++)
        {
            count[array.getArrValue(i) - min]++;
        }

        for (int i = 1; i < count.length; i++)
        {
            count[i] += count[i - 1];
        }

        for (int i = array.arrSize() - 1; i >= 0; i--)
        {
            output[count[array.getArrValue(i) - min] - 1] = array.getArrValue(i);
            count[array.getArrValue(i) - min]--;
        }

        for (int i = 0; i < array.arrSize(); i++)
        {
            array.setArrayValue(i, output[i]);
        }
    }

    @Override
    public String algorithmName()
    {
        return "Counting";
    }
}
