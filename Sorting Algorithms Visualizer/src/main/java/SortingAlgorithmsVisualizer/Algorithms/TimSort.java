package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class TimSort implements SortAlgorithm
{
    static int MIN_MERGE = 32;

    @Override
    public void runSort(ArrayManager array)
    {
        int n = array.getArraySize();

        int minRun = minRunLength(MIN_MERGE);

        for (int i = 0; i < n; i += minRun)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            insertionSort(array, i, Math.min((i + MIN_MERGE - 1), (n - 1)));
        }

        for (int size = minRun; size < n; size = 2 * size)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            for (int left = 0; left < n; left += 2 * size)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if(mid < right)
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    merge(array, left, mid, right);
                }
            }
        }
    }

    private static void insertionSort(ArrayManager array, int left, int right)
    {
        for (int i = left + 1; i <= right; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            int temp = array.getArrayValue(i);
            int j = i - 1;
            while (j >= left && array.getArrayValue(j) > temp)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                array.setArrayValue(j + 1, array.getArrayValue(j));
                j--;
            }
            array.setArrayValue(j + 1, temp);
        }
    }

    public static void merge(ArrayManager array, int l, int m, int r)
    {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        for (int x = 0; x < len1; x++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            left[x] = array.getArrayValue(l + x);
        }
        for (int x = 0; x < len2; x++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            right[x] = array.getArrayValue(m + 1 + x);
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < len1 && j < len2)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            if (left[i] <= right[j])
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                array.setArrayValue(k, left[i]);
                i++;
            }
            else {
                array.setArrayValue(k, right[j]);
                j++;
            }
            k++;
        }

        while (i < len1)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            array.setArrayValue(k, left[i]);
            k++;
            i++;
        }

        while (j < len2)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);
            array.setNumOfComparisions(array.getNumOfComparisions() + 1);

            array.setArrayValue(k, right[j]);
            k++;
            j++;
        }
    }

    private static int minRunLength(int n)
    {
        assert n >= 0;

        // Becomes 1 if any 1 bits are shifted off
        int r = 0;
        while (n >= MIN_MERGE)
        {
            r |= (n & 1);
            n >>= 1;
        }
        return n + r;
    }

    @Override
    public String getAlgorithmName()
    {
        return "Tim sort";
    }
}
