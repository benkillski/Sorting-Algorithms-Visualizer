package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class BrickSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int n = array.arrSize();
        boolean isSorted = false;

        while (!isSorted)
        {
            isSorted = true;
            int temp =0;

            for (int i = 1; i <= n - 2; i += 2)
            {
                if (array.getArrValue(i) > array.getArrValue(i + 1))
                {
                    array.swap(i, i + 1);
                    isSorted = false;
                }
            }

            for (int i = 0; i <= n - 2; i += 2)
            {
                if (array.getArrValue(i) > array.getArrValue(i + 1))
                {
                    array.swap(i, i + 1);
                    isSorted = false;
                }
            }
        }

        return;
    }

    @Override
    public String algorithmName()
    {
        return "Brick Sort";
    }
}
