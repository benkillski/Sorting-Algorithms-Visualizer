package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

//TODO: FIX BITONIC SORT LOGIC
public class BitonicSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int up = 1;
        bitonicSort(array, 0, array.getArraySize(), up);
    }

    void bitonicSort(ArrayManager array, int low, int cnt, int dir)
    {
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        if (cnt>1)
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

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
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        if (cnt > 1)
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            int k = cnt / 2;
            for (int i = low; i < low + k; i++)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                compAndSwap(array, i, i + k, dir);
            }
            bitonicMerge(array, low, k, dir);
            bitonicMerge(array,low + k, k, dir);
        }
    }

    private void compAndSwap(ArrayManager array, int i, int j, int dir)
    {
        if ( (array.getArrayValue(i) > array.getArrayValue(j) && dir == 1) || (array.getArrayValue(i) < array.getArrayValue(j) && dir == 0) )
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            array.swap(i, j);
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Bitonic Sort";
    }
}
