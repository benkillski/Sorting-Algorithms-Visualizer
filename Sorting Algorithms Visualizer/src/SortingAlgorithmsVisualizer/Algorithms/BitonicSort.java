package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class BitonicSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int up = 1;
        bitonicSort(array, 0, array.arrSize(), up);
    }

    void bitonicSort(ArrayManager array, int low, int cnt, int dir)
    {
        if (cnt>1)
        {
            int k = cnt/2;

            // sort in ascending order since dir here is 1
            bitonicSort(array, low, k, 1);

            // sort in descending order since dir here is 0
            bitonicSort(array,low+k, k, 0);

            // Will merge wole sequence in ascending order
            // since dir=1.
            bitonicMerge(array, low, cnt, dir);
        }
    }

    private void bitonicMerge(ArrayManager array, int low, int cnt, int dir)
    {
        if (cnt > 1)
        {
            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
                compAndSwap(array, i, i + k, dir);
            bitonicMerge(array, low, k, dir);
            bitonicMerge(array,low + k, k, dir);
        }
    }

    private void compAndSwap(ArrayManager array, int i, int j, int dir)
    {
        if ( (array.getArrValue(i) > array.getArrValue(j) && dir == 1) ||
                (array.getArrValue(i) < array.getArrValue(j) && dir == 0))
        {
            array.swap(i, j);
        }
    }

    @Override
    public String algorithmName()
    {
        return "Bitonic Sort";
    }
}
