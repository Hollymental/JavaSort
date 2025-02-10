package app;

import factory.ModelFactory;
import factory.SortingStrategyFactory;
import model.Bus;
import model.Student;
import model.User;
import service.SortingService;
import strategy.SortingStrategy;
import util.InputValidator;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class SortingApplication {
    private static final Scanner scanner = new Scanner(System.in);

    public static void run(String[] args) {
        while (true) {
            System.out.println("Выберите тип данных для сортировки:");
            System.out.println("1. Автобусы");
            System.out.println("2. Студенты");
            System.out.println("3. Пользователи");
            System.out.println("100. Выход");

            int choice = getIntInput("Ваш выбор: ");

            switch (choice) {
                case 1:
                    processBuses();
                    break;
                case 2:
                    processStudents();
                    break;
                case 3:
                    processUsers();
                    break;
                case 100:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void processBuses() {
        Bus[] buses = createArray(Bus.class);
        processArray(buses, "Bus");
    }

    private static void processStudents() {
        Student[] students = createArray(Student.class);
        processArray(students, "Student");
    }

    private static void processUsers() {
        User[] users = createArray(User.class);
        processArray(users, "User");
    }

    private static <T extends Comparable<T>> T[] createArray(Class<T> clazz) {
        System.out.println("Выберите способ заполнения массива:");
        System.out.println("1. Случайно");
        System.out.println("2. Вручную");
        //System.out.println("3. Из файла");

        int choice = getIntInput("Ваш выбор: ");
        int size = getIntInput("Введите размер массива: ");

        T[] array = (T[]) java.lang.reflect.Array.newInstance(clazz, size);

        switch (choice) {
            case 1:
                fillArrayRandomly(array, clazz);
                break;
            case 2:
                fillArrayManually(array, clazz);
                break;
            //case 3:
            //fillArrayFromFile(array, clazz);
            //break;
            default:
                System.out.println("Неверный выбор. Заполняем случайно.");
                fillArrayRandomly(array, clazz);
        }

        return array;
    }

    private static <T> void fillArrayRandomly(T[] array, Class<T> clazz) {
        for (int i = 0; i < array.length; i++) {
            if (clazz == Bus.class) {
                array[i] = clazz.cast(ModelFactory.createRandomBus());
            } else if (clazz == Student.class) {
                array[i] = clazz.cast(ModelFactory.createRandomStudent());
            } else if (clazz == User.class) {
                array[i] = clazz.cast(ModelFactory.createRandomUser());
            } else {
                throw new IllegalArgumentException("Неподдерживаемый тип массива");
            }
        }
    }

    private static <T> void fillArrayManually(T[] array, Class<T> clazz) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите данные для элемента " + (i + 1) + ":");
            if (clazz == Bus.class) {
                array[i] = clazz.cast(ModelFactory.createBus(
                        getIntInput("Номер: "),
                        getStringInput("Модель: "),
                        getIntInput("Пробег: ")));
            } else if (clazz == Student.class) {
                array[i] = clazz.cast(ModelFactory.createStudent(
                        getStringInput("Номер группы: "),
                        getDoubleInput("Средний балл: "),
                        getIntInput("Номер зачетной книжки: ")));
            } else if (clazz == User.class) {
                array[i] = clazz.cast(ModelFactory.createUser(
                        getStringInput("Имя пользователя: "),
                        getStringInput("Пароль: "),
                        getStringInput("Электронная почта: ")));
            } else {
                throw new IllegalArgumentException("Неподдерживаемый тип массива");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }
    }

    // quicksort evenoddquicksort
    private static <T extends Comparable<T>> void processArray(T[] array, String type) {
        System.out.println("Ваш выбор сортировки 1- quicksort");

        int sortChoice = scanner.nextInt();
        String strategyName = (sortChoice == 1) ? "quicksort" : "";

        SortingStrategy<T> strategy = SortingStrategyFactory.createSortingStrategy(strategyName,
                (Class<T>) array.getClass().getComponentType());
        SortingService<T> sortingService = new SortingService<>(strategy);

        System.out.println("Исходный массив:");
        sortingService.printArray(array);

        sortingService.sort(array);

        System.out.println("Отсортированный массив:");
        sortingService.printArray(array);

        System.out.println("Хотите сохранить результат в файл? (y/n)");
        if (scanner.next().equalsIgnoreCase("y")) {
            saveToFile(array);
        }
    }

//    private static <T> void fillArrayRandomly(T[] array) {
//        for (int i = 0; i < array.length; i++) {
//            array[i] = (T) ModelFactory.createRandomBus();
//        }
//    }
//
//    private static <T> void fillArrayManually(T[] array) {
//        for (int i = 0; i < array.length; i++) {
//            System.out.println("Введите данные для элемента " + (i + 1) + ":");
//            array[i] = (T) ModelFactory.createBus(
//                    getIntInput("Номер: "),
//                    getStringInput("Модель: "),
//                    getIntInput("Пробег: "));
//        }
//    }

    private static <T> void fillArrayFromFile(T[] array, Class<T> clazz) {
        String fileName = getStringInput("Введите имя файла: ");

        if (clazz == Bus.class) {

        } else if (clazz == Student.class) {

        } else if (clazz == User.class) {

        } else {
            throw new IllegalArgumentException("Неподдерживаемый тип массива");
        }

    }

    private static <T> void saveToFile(T[] array) {
        String fileName = getStringInput("Введите имя файла для сохранения: ");
//        try {
//            FileUtils.writeToFile(fileName, Collections.singletonList(array), false);
//            System.out.println("Данные успешно сохранены в файл " + fileName);
//        } catch (IOException e) {
//            System.out.println("Ошибка при сохранении в файл: " + e.getMessage());
//        }
    }

    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (InputValidator.isPositiveInteger(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("Пожалуйста, введите положительное целое число.");
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    private static int getSearchKey(String type) {
        return switch (type) {
            case "Bus" -> getIntInput("Введите номер автобуса для поиска: ");
            //case "User" -> getStringInput("Введите имя пользователя для поиска: ");
            case "Student" -> getIntInput("Введите номер зачетной книжки для поиска: ");
            default -> throw new IllegalArgumentException("Неизвестный тип: " + type);
        };
    }

}
