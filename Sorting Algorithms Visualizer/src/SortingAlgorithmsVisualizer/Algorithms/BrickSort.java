package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class BrickSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int n = array.getArraySize();
        boolean isSorted = false;

        while (!isSorted)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            isSorted = true;
            int temp = 0;

            for (int i = 1; i <= n - 2; i += 2)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if (array.getArrayValue(i) > array.getArrayValue(i + 1))
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    array.swap(i, i + 1);
                    isSorted = false;
                }
            }

            for (int i = 0; i <= n - 2; i += 2)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if (array.getArrayValue(i) > array.getArrayValue(i + 1))
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    array.swap(i, i + 1);
                    isSorted = false;
                }
            }
        }

        return;
    }

    @Override
    public String getAlgorithmName()
    {
        return "Brick Sort";
    }
}
