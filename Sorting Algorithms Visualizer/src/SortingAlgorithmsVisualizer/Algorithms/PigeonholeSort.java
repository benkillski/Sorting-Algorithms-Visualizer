package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

import java.util.Arrays;

public class PigeonholeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.getArraySize();

        int min = array.getArrayValue(0);
        int max = array.getArrayValue(0);
        int range, i, j, index;

        for(int a = 0; a < size; a++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            if(array.getArrayValue(a) > max)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                max = array.getArrayValue(a);
            }

            if(array.getArrayValue(a) < min)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                min = array.getArrayValue(a);
            }
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i < size; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            phole[array.getArrayValue(i) - min]++;
        }

        index = 0;

        for(j = 0; j < range; j++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            while (phole[j]-- > 0)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                array.setArrayValue(index++, j + min);
            }
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Pigeonhole Sort";
    }
}
