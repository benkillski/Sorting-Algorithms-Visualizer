package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class PancakeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int n = array.getArraySize();

        for (int curr_size = n; curr_size > 1; --curr_size)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            int mi = findMax(array, curr_size);

            if (mi != curr_size-1)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                flip(array, mi);

                flip(array, curr_size-1);
            }
        }
    }

    private static int findMax(ArrayManager array, int n)
    {
        int mi, i;
        for (mi = 0, i = 0; i < n; ++i)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            if (array.getArrayValue(i) > array.getArrayValue(mi))
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                mi = i;
            }
        }
        return mi;
    }

    private static void flip(ArrayManager array, int i)
    {
        int start = 0;
        while (start < i)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            array.swap(start, i);
            start++;
            i--;
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Pancake Sort";
    }
}
