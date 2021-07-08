package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class QuickSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        quickSort(array, 0, array.arrSize() - 1);
    }

    private void quickSort(ArrayManager array, int start, int end)
    {
        if(start < end)
        {
            int partitioningIndex = partition(array, start, end);

            quickSort(array, start, partitioningIndex - 1);
            quickSort(array, partitioningIndex + 1, end);
        }
    }

    private int partition(ArrayManager array, int start, int end)
    {
        int pivot = array.getArrValue(end);

        int i = (start - 1);

        for(int j = start; j <= end - 1; j++)
        {
            if(array.getArrValue(j) < pivot)
            {
                i++;
                array.swap(i, j);
            }
        }
        array.swap(i + 1, end);
        return (i + 1);
    }
}
