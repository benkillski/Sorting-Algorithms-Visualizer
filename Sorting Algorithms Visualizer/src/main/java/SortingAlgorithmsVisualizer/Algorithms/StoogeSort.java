package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class StoogeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        stoogeSort(array, 0, array.getArraySize() - 1);
    }

    private void stoogeSort(ArrayManager array, int l, int h)
    {
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        if (l >= h)
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            return;
        }

        if (array.getArrayValue(l) > array.getArrayValue(h))
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            array.swap(l, h);
        }

        if (h - l + 1 > 2)
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            int t = (h - l + 1) / 3;

            stoogeSort(array, l, h - t);

            stoogeSort(array, l + t, h);

            stoogeSort(array, l, h - t);
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Stooge sort";
    }
}
