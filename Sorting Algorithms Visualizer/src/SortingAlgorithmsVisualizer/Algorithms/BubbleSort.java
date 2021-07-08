package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class BubbleSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.arrSize();
        for(int i = 0; i < size - 1; i++)
        {
            for(int j = 0; j < size - 1; j++)
            {
                if(array.getArrValue(j) > array.getArrValue(j + 1))
                {
                    array.swap(j, j + 1);
                }
            }
        }
    }

    @Override
    public String algorithmName()
    {
        return "Bubble";
    }
}
