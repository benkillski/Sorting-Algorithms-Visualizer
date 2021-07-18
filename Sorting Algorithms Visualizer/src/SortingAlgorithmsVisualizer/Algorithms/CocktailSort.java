package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class CocktailSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        boolean swapped = true;
        int start = 0;
        int end = array.arrSize();

        while (swapped == true)
        {
            swapped = false;

            for (int i = start; i < end - 1; ++i)
            {
                if (array.getArrValue(i) > array.getArrValue(i + 1))
                {
                    array.swap(i, i + 1);
                    swapped = true;
                }
            }

            if (swapped == false)
                break;

            swapped = false;

            end = end - 1;

            for (int i = end - 1; i >= start; i--)
            {
                if (array.getArrValue(i) > array.getArrValue(i + 1))
                {
                    array.swap(i, i + 1);
                    swapped = true;
                }
            }
            start = start + 1;
        }
    }

    @Override
    public String algorithmName()
    {
        return "Cocktail Sort";
    }
}
