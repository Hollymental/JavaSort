public class SortingService<T extends Comparable<T>> {

    private SortingStrategy<T> strategy;

    public SortingService(SortingStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SortingStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public void sort(T[] array) {
        strategy.sort(array);
    }

    public void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}

