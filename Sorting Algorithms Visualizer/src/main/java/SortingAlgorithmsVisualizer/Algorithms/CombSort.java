package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class CombSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.getArraySize();

        int gap = size;

        boolean swapped = true;

        while (gap != 1 || swapped == true)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            gap = getNextGap(gap);

            swapped = false;

            for (int i = 0; i  < size - gap; i++)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if (array.getArrayValue(i) > array.getArrayValue(i+gap))
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    int temp = array.getArrayValue(i);
                    array.setArrayValue(i, array.getArrayValue(i + gap));
                    array.setArrayValue(i + gap, temp);

                    swapped = true;
                }
            }
        }
    }

    int getNextGap(int gap)
    {
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    @Override
    public String getAlgorithmName()
    {
        return "Comb Sort";
    }
}
