package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

//This algorithm is ass LMAO
public class BogoSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        while (isSorted(array) == false)
            shuffle(array);
    }

    private void shuffle(ArrayManager array)
    {
        for (int i = 0; i <= array.arrSize() - 1; i++)
            swap(array, i, (int) (Math.random() * i));
    }

    private void swap(ArrayManager array, int i, int j)
    {
        array.swap(i, j);
    }

    private boolean isSorted(ArrayManager array)
    {
        for (int i = 1; i < array.arrSize(); i++)
            if (array.getArrValue(i) < array.getArrValue(i - 1))
                return false;
        return true;
    }

    @Override
    public String algorithmName()
    {
        return "Bogo Sort";
    }
}
