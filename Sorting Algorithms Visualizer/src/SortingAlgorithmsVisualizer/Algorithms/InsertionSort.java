package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class InsertionSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.arrSize();
        for (int i = 0; i < size; i++)
        {
            int key = array.getArrValue(i);
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array.getArrValue(j) > key)
            {
                array.setArrayValue(j + 1, array.getArrValue(j));
                j--;
            }
            array.setArrayValue(j + 1, key);
        }
    }

    @Override
    public String algorithmName()
    {
        return "Insertion Sort";
    }
}
