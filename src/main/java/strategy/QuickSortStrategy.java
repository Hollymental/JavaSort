package strategy;

import algorithm.QuickSort;

public class QuickSortStrategy<T extends Comparable<T>> implements SortingStrategy<T> {

    private final QuickSort<T> quickSort;

    public QuickSortStrategy() {
        this.quickSort = new QuickSort<>();
    }

    @Override
    public void sort(T[] array) {
        quickSort.sort(array);
    }
}
