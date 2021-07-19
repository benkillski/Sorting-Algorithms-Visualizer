package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class BubbleSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.getArraySize();
        for(int i = 0; i < size - 1; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            for(int j = 0; j < size - 1; j++)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if(array.getArrayValue(j) > array.getArrayValue(j + 1))
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    array.swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Bubble Sort";
    }
}
