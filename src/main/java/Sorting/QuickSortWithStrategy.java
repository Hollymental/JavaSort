package Sorting;

import Classes.Bus;
import Classes.Student;
import Classes.User;
import Comparators.ComparatorStrategy;

public class QuickSortWithStrategy<T extends Comparable<T>> {

    private ComparatorStrategy<T> strategy;

    public QuickSortWithStrategy() {
    }

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

    public void evenSort(T[] originalItems, T[] evenItems, int[] evenIndices){
        quickSort(evenItems, 0, evenItems.length - 1);
        for (int i = 0; i < evenItems.length; i++){
            originalItems[evenIndices[i]] = evenItems[i];
        }
        if (originalItems[0] instanceof User){
            printArrayIsEvenWithHashCode(originalItems);
        } else {
            printArrayWithEven(originalItems);
        }
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

    public void printArrayWithEven(T[] array) {
        for (T element : array) {
            if (element instanceof Bus){
                System.out.println(element  + " " + isEven(((Bus) element).getMileage()));
            } else if (element instanceof Student){
                System.out.println(element  + " " + isEven(((Student) element).getRecordBookNumber()));
            }
        }
    }

    public void printArrayIsEvenWithHashCode(T[] array) {
        for (T element : array) {
            if (element.hashCode() >= 0){
                System.out.println(String.format("%s hashcode:  %-11d %-3s", element, element.hashCode(), isEven(element.hashCode())));
            } else {
                System.out.println(String.format("%s hashcode: %-11d  %-3s", element, element.hashCode(), isEven(element.hashCode())));
            }
        }
    }

    public String isEven(int value){
        if (value % 2 == 0){
            return "even";
        } else {
            return "odd";
        }
    }
}
