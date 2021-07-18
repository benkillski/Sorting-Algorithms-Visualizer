package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class CombSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.arrSize();

        int gap = size;

        boolean swapped = true;

        while (gap != 1 || swapped == true)
        {
            gap = getNextGap(gap);

            swapped = false;

            for (int i = 0; i  < size - gap; i++)
            {
                if (array.getArrValue(i) > array.getArrValue(i+gap))
                {
                    int temp = array.getArrValue(i);
                    array.setArrayValue(i, array.getArrValue(i + gap));
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
    public String algorithmName()
    {
        return "Comb Sort";
    }
}
