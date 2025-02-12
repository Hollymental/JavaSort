
public class QuickSortWithStrategy<T extends Comparable<T>> {

    private ComparatorStrategy<T> strategy;

    public QuickSortWithStrategy(ComparatorStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ComparatorStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(T[] items) {
        quickSort(items, 0, items.length - 1);
        printArray(items);
    }

    private void quickSort(T[] items, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(items, low, high);
            quickSort(items, low, pivotIndex - 1);
            quickSort(items, pivotIndex + 1, high);
        }
    }

    private int partition(T[] items, int low, int high) {

        T pivot = items[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (strategy.compare(items[j], pivot) <= 0) {
                i++;
                swap(items, i, j);
            }
        }
        swap(items, i + 1, high);
        return i + 1;
    }

    private void swap(T[] items, int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
