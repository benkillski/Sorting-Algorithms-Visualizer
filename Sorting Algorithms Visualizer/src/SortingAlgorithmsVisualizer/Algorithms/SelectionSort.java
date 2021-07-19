package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class SelectionSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.getArraySize();
        for (int i = 0; i < size - 1; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < size; j++)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if (array.getArrayValue(j) < array.getArrayValue(minIndex)) {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            array.swap(minIndex, i);
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Selection Sort";
    }
}
