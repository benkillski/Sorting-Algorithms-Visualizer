package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class InsertionSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.getArraySize();
        for (int i = 0; i < size; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            int key = array.getArrayValue(i);
            int j = i - 1;

            while (j >= 0 && array.getArrayValue(j) > key)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                array.setArrayValue(j + 1, array.getArrayValue(j));
                j--;
            }
            array.setArrayValue(j + 1, key);
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Insertion Sort";
    }
}
