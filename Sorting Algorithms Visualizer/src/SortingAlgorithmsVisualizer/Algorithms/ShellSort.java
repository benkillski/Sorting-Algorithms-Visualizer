package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class ShellSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.getArraySize();

        for (int gap = size/2; gap > 0; gap /= 2)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            for (int i = gap; i < size; i += 1)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                int temp = array.getArrayValue(i);

                int j;
                for (j = i; j >= gap && array.getArrayValue(j - gap) > temp; j -= gap)
                {
                    array.setNumOfIterations(array.getNumOfIterations() + 1);
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    array.setArrayValue(j, array.getArrayValue(j - gap));
                }

                array.setArrayValue(j, temp);
            }
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Shell sort";
    }
}
