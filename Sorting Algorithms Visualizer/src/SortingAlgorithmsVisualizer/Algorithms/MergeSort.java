package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class MergeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        mergeSort(array, 0, array.getArraySize() - 1);
    }

    private void mergeSort(ArrayManager array, int left, int right)
    {
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        if(left < right)
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(ArrayManager array, int left, int mid, int right)
    {
        int[] temp = new int[right - left + 1];

        int i = left, j = mid + 1, k = 0;

        while(i <= mid && j <= right)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            if(array.getArrayValue(i) <= array.getArrayValue(j))
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                temp[k] = array.getArrayValue(i);
                k++;
                i++;
            }
            else
            {
                temp[k] = array.getArrayValue(j);
                k++;
                j++;
            }
        }

        while(i <= mid)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            temp[k] = array.getArrayValue(i);
            k++;
            i++;
        }

        while(j <= right)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            temp[k] = array.getArrayValue(j);
            k++;
            j++;
        }

        for(i = left; i <= right; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            array.setArrayValue(i, temp[i - left]);
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Merge Sort";
    }
}
