package SortingAlgorithmsVisualizer.Algorithms;

import SortingAlgorithmsVisualizer.ArrayManager;

public class CycleSort implements SortAlgorithm
{
    @Override
    public void runSort(ArrayManager array)
    {
        int size = array.arrSize();

        int writes = 0;

        for (int cycle_start = 0; cycle_start <= size - 2; cycle_start++) {
            int item = array.getArrValue(cycle_start);

            int pos = cycle_start;
            for (int i = cycle_start + 1; i < size; i++)
                if (array.getArrValue(i) < item)
                    pos++;

            if (pos == cycle_start)
                continue;

            while (item == array.getArrValue(pos))
                pos += 1;

            if (pos != cycle_start) {
                int temp = item;
                item = array.getArrValue(pos);
                array.setArrayValue(pos, temp);
                writes++;
            }

            while (pos != cycle_start) {
                pos = cycle_start;

                for (int i = cycle_start + 1; i < size; i++)
                    if (array.getArrValue(i) < item)
                        pos += 1;

                while (item == array.getArrValue(pos))
                    pos += 1;

                if (item != array.getArrValue(pos)) {
                    int temp = item;
                    item = array.getArrValue(pos);
                    array.setArrayValue(pos, temp);
                    writes++;
                }
            }
        }
    }

    @Override
    public String algorithmName()
    {
        return "Cycle Sort";
    }
}
