package Sorting;

public class SortingStrategyFactory {
    public static <T extends Comparable<T>> SortingStrategy<T> createQuickSortStrategy() {
        return new QuickSortStrategy<>();
    }

    public static <T extends Comparable<T>> SortingStrategy<T> createSortingStrategy(String strategyName, Class<T> clazz) {
        switch (strategyName.toLowerCase()) {
            case "quicksort":
                return createQuickSortStrategy();
            default:
                throw new IllegalArgumentException("Unknown sorting strategy: " + strategyName);
        }
    }

}
