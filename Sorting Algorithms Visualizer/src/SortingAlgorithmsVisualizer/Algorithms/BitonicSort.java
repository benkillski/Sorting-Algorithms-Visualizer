package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

//Only works on lists whose sizes are a power of 2
public class BitonicSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int up = 1;
        bitonicSort(array, 0, array.getArraySize(), up);
    }

    private void bitonicSort(ArrayManager array, int low, int count, int dir)
    {
        if(count > 1)
        {
            int k = count / 2;

            bitonicSort(array, low, k, 1);

            bitonicSort(array, low + k, k, 0);

            bitonicMerge(array, low, count, dir);
        }
    }

    private void bitonicMerge(ArrayManager array, int low, int count, int dir)
    {
        if(count > 1)
        {
            int k = count / 2;
            for(int i = low; i < low + k; i++)
                compAndSwap(array, i, i + k, dir);
            bitonicMerge(array, low, k, dir);
            bitonicMerge(array, low + k, k, dir);
        }
    }

    private void compAndSwap(ArrayManager array, int i, int j, int dir)
    {
        if((array.getArrayValue(i) > array.getArrayValue(j) && dir == 1) || (array.getArrayValue(i) < array.getArrayValue(j) && dir == 0))
            array.swap(i, j);
    }

    @Override
    public String getAlgorithmName()
    {
        return "Bitonic Sort";
    }
}
