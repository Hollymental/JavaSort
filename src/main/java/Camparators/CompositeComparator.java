package Camparators;

public class CompositeComparator<T extends Comparable<T>> implements ComparatorStrategy<T> {
    private ComparatorStrategy<T>[] strategies;

        public CompositeComparator(ComparatorStrategy<T>... strategies) {
        this.strategies = strategies;
    }

    @Override
    public int compare(T o1, T o2) {
        for (ComparatorStrategy<T> strategy : strategies) {
            int result = strategy.compare(o1, o2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}

