import java.util.Scanner;

public class ArrayCreator {

    public static <T> T[] createArray(
            String entityType,
            int size,
            ArrayHandler<T> handler
    ) {
        System.out.println("Выберите способ заполнения массива " + entityType + ":");
        System.out.println("1. Случайно");
        System.out.println("2. Вручную");
        System.out.println("3. Из файла");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваш выбор: ");
        int choice = scanner.nextInt();

        T[] array = handler.createArray(size);

        switch (choice) {
            case 1:
                handler.fillArrayRandomly(array, size);
                break;
            case 2:
                handler.fillArrayManually(array, size);
                break;
            case 3:
                handler.fillArrayFromFile(array, size);
                break;
            default:
                System.out.println("Неверный выбор. Заполняем случайно.");
                handler.fillArrayRandomly(array, size);
        }

        return array;
    }

    public interface ArrayHandler<T> {
        T[] createArray(int size);
        void fillArrayRandomly(T[] array, int size);
        void fillArrayManually(T[] array, int size);
        void fillArrayFromFile(T[] array, int size);
    }
}