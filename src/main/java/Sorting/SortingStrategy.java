package Sorting;

public interface SortingStrategy<T extends Comparable<T>> {

    void sort(T[] array);
}

