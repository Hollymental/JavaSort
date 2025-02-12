package BinarySearch;

public class SearchService<T extends Comparable<T>> {
    private final BinarySearch<T> binarySearch;

    public SearchService() {
        this.binarySearch = new BinarySearch<T>();
    }

    public int search(T[] array, String key) {
        return binarySearch.search(array, key);
    }

    public void printSearchResult(T[] array, String key) {
        int result = search(array, key);
        if (result != -1) {

            System.out.println("Элемент с поисковыми данными " + key + " найден в позиции " + result);
            System.out.println("Найденный элемент: " + array[result]);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}
