package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

//This algorithm is ass LMAO
public class BogoSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        while (isSorted(array) == false)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            shuffle(array);
        }
    }

    private void shuffle(ArrayManager array)
    {
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        for (int i = 0; i <= array.getArraySize() - 1; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            swap(array, i, (int) (Math.random() * i));
        }
    }

    private void swap(ArrayManager array, int i, int j)
    {
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        array.swap(i, j);
    }

    private boolean isSorted(ArrayManager array)
    {
        for (int i = 1; i < array.getArraySize(); i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            if (array.getArrayValue(i) < array.getArrayValue(i - 1))
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                return false;
            }
        }
        return true;
    }

    @Override
    public String getAlgorithmName()
    {
        return "Bogo Sort";
    }
}
