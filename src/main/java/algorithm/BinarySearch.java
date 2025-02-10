package algorithm;

import model.Bus;
import model.Student;
import model.User;

public class BinarySearch<T extends Comparable<T>>{

    public int search(T[] arr, String key) {
        return binarySearch(arr, key, 0, arr.length - 1);
    }

    private int binarySearch(T[] arr, String key, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            String midValue = getSearchKey(arr[mid]);

            int comparisonResult = midValue.compareTo(key);

            if (comparisonResult == 0) {
                return mid;
            }

            if (comparisonResult > 0) {
                return binarySearch(arr, key, low, mid - 1);
            }

            return binarySearch(arr, key, mid + 1, high);
        }

        return -1;
    }

    private String getSearchKey(T item) {
        if (item instanceof Student) {
            return ((Student) item).getRecordBookNumber();
        }
        if (item instanceof Bus) {
            return ((Bus) item).getNumber();
        }
        if (item instanceof User) {
            return ((User) item).getName();
        }
        throw new IllegalArgumentException("Unsupported type for search");
    }
}
