package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class SelectionSort implements SortAlgorithm {
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.arrSize();
        for (int i = 0; i < size - 1; i++)
        {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < size; j++)
                if (array.getArrValue(j) < array.getArrValue(minIndex))
                    minIndex = j;

            // Swap the found minimum element with the first element
            array.swap(minIndex, i);
        }
    }

    @Override
    public String algorithmName()
    {
        return "Selection";
    }
}
