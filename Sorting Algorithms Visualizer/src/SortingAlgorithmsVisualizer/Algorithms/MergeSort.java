package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class MergeSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        mergeSort(array, 0, array.arrSize() - 1);
    }

    private void mergeSort(ArrayManager array, int left, int right)
    {
        if(left < right)
        {
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
            if(array.getArrValue(i) <= array.getArrValue(j))
            {
                temp[k] = array.getArrValue(i);
                k++;
                i++;
            }
            else
            {
                temp[k] = array.getArrValue(j);
                k++;
                j++;
            }
        }

        while(i <= mid)
        {
            temp[k] = array.getArrValue(i);
            k++;
            i++;
        }

        while(j <= right)
        {
            temp[k] = array.getArrValue(j);
            k++;
            j++;
        }

        for(i = left; i <= right; i++)
            array.setArrayValue(i, temp[i - left]);
    }

    @Override
    public String algorithmName()
    {
        return "Merge";
    }
}
