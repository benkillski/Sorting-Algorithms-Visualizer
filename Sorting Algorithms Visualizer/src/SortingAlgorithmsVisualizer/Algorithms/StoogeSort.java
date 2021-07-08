package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

import java.lang.reflect.Array;

public class StoogeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        stoogeSort(array, 0, array.arrSize() - 1);
    }

    private void stoogeSort(ArrayManager array, int l, int h)
    {
        if (l >= h)
            return;

        if (array.getArrValue(l) > array.getArrValue(h))
            array.swap(l, h);

        if (h - l + 1 > 2)
        {
            int t = (h - l + 1) / 3;

            stoogeSort(array, l, h - t);

            stoogeSort(array, l + t, h);

            stoogeSort(array, l, h - t);
        }
    }

    @Override
    public String algorithmName()
    {
        return null;
    }
}
