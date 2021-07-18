package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class GnomeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int index = 0;
        int n = array.arrSize();

        while (index < n) {
            if (index == 0)
            {
                index++;
            }
            if (array.getArrValue(index) >= array.getArrValue(index - 1))
            {
                index++;
            }
            else
            {
                array.swap(index, index - 1);
                index--;
            }
        }
        return;
    }

    @Override
    public String algorithmName()
    {
        return "Gnome Sort";
    }
}
