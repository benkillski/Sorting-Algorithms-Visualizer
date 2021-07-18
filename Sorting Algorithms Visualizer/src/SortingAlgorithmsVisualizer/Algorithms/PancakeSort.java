package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;
import SortingAlgorithmsVisualizer.Main;

public class PancakeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int n = array.arrSize();

        for (int curr_size = n; curr_size > 1;
             --curr_size)
        {
            int mi = findMax(array, curr_size);

            if (mi != curr_size-1)
            {
                flip(array, mi);

                flip(array, curr_size-1);
            }
        }
    }

    private static int findMax(ArrayManager array, int n)
    {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
            if (array.getArrValue(i) > array.getArrValue(mi))
            {
                mi = i;
            }
        return mi;
    }

    private static void flip(ArrayManager array, int i)
    {
        int start = 0;
        while (start < i)
        {
            array.swap(start, i);
            start++;
            i--;
        }
    }

    @Override
    public String algorithmName()
    {
        return "Pancake Sort";
    }
}
