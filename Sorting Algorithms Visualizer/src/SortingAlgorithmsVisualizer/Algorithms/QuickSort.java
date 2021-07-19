package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class QuickSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        quickSort(array, 0, array.getArraySize() - 1);
    }

    private void quickSort(ArrayManager array, int start, int end)
    {
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        if(start < end)
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            int partitioningIndex = partition(array, start, end);

            quickSort(array, start, partitioningIndex - 1);
            quickSort(array, partitioningIndex + 1, end);
        }
    }

    private int partition(ArrayManager array, int start, int end)
    {
        int pivot = array.getArrayValue(end);

        int i = (start - 1);

        for(int j = start; j <= end - 1; j++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            if(array.getArrayValue(j) < pivot)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                i++;
                array.swap(i, j);
            }
        }
        array.swap(i + 1, end);
        return (i + 1);
    }

    @Override
    public String getAlgorithmName()
    {
        return "Quick Sort";
    }
}
