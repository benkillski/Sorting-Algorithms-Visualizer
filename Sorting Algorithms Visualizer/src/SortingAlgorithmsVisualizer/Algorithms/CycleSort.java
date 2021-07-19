package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class CycleSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.getArraySize();

        int writes = 0;

        for (int cycle_start = 0; cycle_start <= size - 2; cycle_start++)
        {
            array.setNumOfIterations(array.getNumOfIterations() + 1);

            int item = array.getArrayValue(cycle_start);

            int pos = cycle_start;
            for (int i = cycle_start + 1; i < size; i++)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);

                if (array.getArrayValue(i) < item)
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    pos++;
                }
            }

            if (pos == cycle_start)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                continue;
            }

            while (item == array.getArrayValue(pos))
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                pos += 1;
            }

            if (pos != cycle_start)
            {
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                int temp = item;
                item = array.getArrayValue(pos);
                array.setArrayValue(pos, temp);
                writes++;
            }

            while (pos != cycle_start)
            {
                array.setNumOfIterations(array.getNumOfIterations() + 1);
                array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                pos = cycle_start;

                for (int i = cycle_start + 1; i < size; i++)
                {
                    array.setNumOfIterations(array.getNumOfIterations() + 1);

                    if (array.getArrayValue(i) < item)
                    {
                        array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                        pos += 1;
                    }
                }

                while (item == array.getArrayValue(pos))
                {
                    array.setNumOfIterations(array.getNumOfIterations() + 1);
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    pos += 1;
                }

                if (item != array.getArrayValue(pos))
                {
                    array.setNumOfComparisions(array.getNumOfComparisions() + 1);

                    int temp = item;
                    item = array.getArrayValue(pos);
                    array.setArrayValue(pos, temp);
                    writes++;
                }
            }
        }
    }

    @Override
    public String getAlgorithmName()
    {
        return "Cycle Sort";
    }
}
