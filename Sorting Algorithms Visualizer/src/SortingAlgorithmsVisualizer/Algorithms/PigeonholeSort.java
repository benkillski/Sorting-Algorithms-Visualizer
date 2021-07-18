package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;
import SortingAlgorithmsVisualizer.Main;

import java.util.Arrays;

public class PigeonholeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.arrSize();

        int min = array.getArrValue(0);
        int max = array.getArrValue(0);
        int range, i, j, index;

        for(int a = 0; a < size; a++)
        {
            if(array.getArrValue(a) > max)
            {
                max = array.getArrValue(a);
            }

            if(array.getArrValue(a) < min)
            {
                min = array.getArrValue(a);
            }
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i < size; i++)
            phole[array.getArrValue(i) - min]++;

        index = 0;

        for(j = 0; j < range; j++)
            while(phole[j]-- > 0)
                array.setArrayValue(index++, j + min);
    }

    @Override
    public String algorithmName()
    {
        return "Pigeonhole Sort";
    }
}
