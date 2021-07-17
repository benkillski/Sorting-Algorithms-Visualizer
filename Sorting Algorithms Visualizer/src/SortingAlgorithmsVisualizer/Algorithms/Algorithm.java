package SortingAlgorithmsVisualizer.Algorithms;

public enum Algorithm
{
    SELECTION(0),
    BUBBLE(1),
    INSERTION(2),
    MERGE(3),
    HEAP(4),
    QUICK(5),
    RADIX(6),
    COUNTING(7),
    BUCKET(8),
    SHELL(9),
    COMB(10),
    CYCLE(11),
    TIM(12),
    COCKTAIL(13),
    PANCAKE(14),
    BOGO(15),
    GNOME(16),
    STOOGE(17),
    BRICK(18);

    private Algorithm(int index)
    {
        value = index;
    }

    private int value;

    public int getValue()
    {
        return value;
    }
}
