package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class HeapSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int n = array.getArraySize();
        for(int i = n / 2 - 1; i >= 0; i--)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            heapify(array, n, i);
        }

        for(int i = n - 1; i >= 0; i--)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            array.swap(0, i);
            heapify(array, i, 0);
        }
    }

    private void heapify(ArrayManager array, int n, int i)
    {
        array.setNumOfIterations(array.getNumOfIterations() + 1);

        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && array.getArrayValue(l) > array.getArrayValue(largest))
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);
            largest = l;
        }

        // If right child is larger than largest so far
        if (r < n && array.getArrayValue(r) > array.getArrayValue(largest))
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);
            largest = r;
        }

        // If largest is not root
        if (largest != i)
        {
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            int swap = array.getArrayValue(i);
            array.setArrayValue(i, array.getArrayValue(largest));
            array.setArrayValue(largest, swap);

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Heap Sort";
    }
}
