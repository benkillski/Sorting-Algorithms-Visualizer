package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class GnomeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int index = 0;
        int n = array.getArraySize();

        while (index < n)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            if (index == 0)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                index++;
            }
            if (array.getArrayValue(index) >= array.getArrayValue(index - 1))
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                index++;
            }
            else
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                array.swap(index, index - 1);
                index--;
            }
        }
        return;
    }

    @Override
    public String getAlgorithmName()
    {
        return "Gnome Sort";
    }
}
