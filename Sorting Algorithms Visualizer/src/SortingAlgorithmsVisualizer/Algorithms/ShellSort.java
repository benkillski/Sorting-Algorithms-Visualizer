package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class ShellSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.arrSize();

        for (int gap = size/2; gap > 0; gap /= 2)
        {
            for (int i = gap; i < size; i += 1)
            {
                int temp = array.getArrValue(i);

                int j;
                for (j = i; j >= gap && array.getArrValue(j - gap) > temp; j -= gap)
                    array.setArrayValue(j, array.getArrValue(j - gap));

                array.setArrayValue(j, temp);
            }
        }
    }

    @Override
    public String algorithmName()
    {
        return "Shell";
    }
}
