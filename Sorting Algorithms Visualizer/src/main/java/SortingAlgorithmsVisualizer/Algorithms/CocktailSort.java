package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class CocktailSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        boolean swapped = true;
        int start = 0;
        int end = array.getArraySize();

        while (swapped == true)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            swapped = false;

            for (int i = start; i < end - 1; ++i)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if (array.getArrayValue(i) > array.getArrayValue(i + 1))
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    array.swap(i, i + 1);
                    swapped = true;
                }
            }

            if (swapped == false)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                break;
            }

            swapped = false;

            end = end - 1;

            for (int i = end - 1; i >= start; i--)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if (array.getArrayValue(i) > array.getArrayValue(i + 1))
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    array.swap(i, i + 1);
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Cocktail Sort";
    }
}
