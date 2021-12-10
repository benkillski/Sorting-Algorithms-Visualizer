package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        List<Integer>[] buckets = new List[array.getArraySize()];

        for(int i = 0; i < buckets.length; i++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            buckets[i] = new LinkedList<>();
        }

        for(int num : array.getArray())
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            buckets[hash(num, buckets.length)].add(num);
        }

        for(List<Integer> bucket : buckets)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            Collections.sort(bucket);
        }

        int index = 0;
        for(List<Integer> bucket : buckets)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            for(int num : bucket)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                array.setArrayValue(index++, num);
            }
        }
    }

    private static int hash(int num, int bucketSize)
    {
        return num / bucketSize;
    }

    @Override
    public String getAlgorithmName()
    {
        return "Bucket Sort";
    }
}
