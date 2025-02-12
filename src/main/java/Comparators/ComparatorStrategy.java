package Comparators;

public interface ComparatorStrategy<T extends Comparable<T>> {
    int compare(T o1, T o2);
}
