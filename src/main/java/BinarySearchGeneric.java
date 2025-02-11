public class BinarySearchGeneric<T extends Comparable<T>> {

    public int binarySearch(T[] arr, T key) {
        if (arr == null || arr.length == 0) {
            System.out.println("пустой массив! Элемент не найден ");
            return -1;
        }

        //quick_sort(arr); // Здесь вызов сортировки, если массив еще не был отсортирован

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Предотвращает переполнение для больших массивов

            int comparisonResult = arr[mid].compareTo(key);

            if (comparisonResult == 0) {
                System.out.println("Объект " + arr[mid] + " найден, индекс объекта: ");
                return  mid; // Элемент найден
            } else if (comparisonResult < 0) {
                low = mid + 1; // Ключ больше, ищем в правой половине
            } else {
                high = mid - 1; // Ключ меньше, ищем в левой половине
            }
        }
        System.out.println("Объект не найден");
        return -1;
    }

}