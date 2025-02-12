package Main;

import Comparators.CompositeComparator;
import Comparators.UserComparators;
import Clases.ModelFactory;
import Clases.User;
import Sorting.QuickSortWithStrategy;
import Validation.InputScanner;

public class ForUser {
    public static void run(String[] args) {

        User[] users = createUserArray();
        processUsers(users);
    }

    private static void processUsers(User[] users) {
        while (true) {
            System.out.println("Ваш выбор:\n" +
                    "1.  Быстрая сортировка\n" +
                    "2.  Кастомная сортировка\n" +
                    "3.  Бинарный поиск\n" +
                    "0.  Выход.");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");
            switch (choice) {
                case 0:
                    return;
                case 1:
                    QuickSortWithStrategy<User> userQuickSortWithStrategy = new QuickSortWithStrategy<>
                            (new CompositeComparator<>(
                                    new UserComparators.SortByName(),
                                    new UserComparators.SortByPassword(),
                                    new UserComparators.SortByEmail()
                            ));
                    userQuickSortWithStrategy.sort(users);
                    break;
                case 2:
                    chooseCustomSort(users);
                    break;
                case 3:
                    userBinarySearch(users);
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void userBinarySearch(User[] users) {
        QuickSortWithStrategy<User> userQuickSortWithStrategy = new QuickSortWithStrategy<>
                (new CompositeComparator<>(
                        new UserComparators.SortByName(),
                        new UserComparators.SortByPassword(),
                        new UserComparators.SortByEmail()
                ));
        userQuickSortWithStrategy.sort(users);
//        SearchService<Clases.User> searchService = new SearchService<>();
//        searchService.printSearchResult(users, getSearchKey());
    }

    private static void chooseCustomSort(User[] users) {
        while (true) {
            System.out.println("Выберите по каким параметрам сортировать (можно несколько до 2 параметров):\n" +
                    "1.  По имени\n" +
                    "2.  По паролю\n" +
                    "3.  По email\n" +
                    "0.  Выход");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");

            switch (choice) {
                case 0:
                    return;
                case 1:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByName())).sort(users);
                    break;
                case 2:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByPassword())).sort(users);
                    break;
                case 3:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByEmail())).sort(users);
                    break;
                case 12:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByName(), new UserComparators.SortByPassword())).sort(users);
                    break;
                case 13:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByName(), new UserComparators.SortByEmail())).sort(users);
                    break;
                case 21:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByPassword(), new UserComparators.SortByName())).sort(users);
                    break;
                case 23:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByPassword(), new UserComparators.SortByEmail())).sort(users);
                    break;
                case 31:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByEmail(), new UserComparators.SortByName())).sort(users);
                    break;
                case 32:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new UserComparators.SortByEmail(), new UserComparators.SortByPassword())).sort(users);
                    break;

                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void fillArrayRandomly(User[] users) {
        for (int i = 0; i < users.length; i++) {
            users[i] = ModelFactory.createRandomUser();
        }
        printArray(users);
    }

    private static void fillArrayManually(User[] users) {
        for (int i = 0; i < users.length; i++) {

            users[i] = ModelFactory.createUser(
                    InputScanner.getStringInput("Имя: "),
                    InputScanner.getStringInput("Пароль: "),
                    InputScanner.getUserEmail("Email: "));
            if (users[i]==null) {
                i--;
            }
        }
        printArray(users);
    }

    private static void fillArrayFromFile(User[] users) {
        users = new FileUpload("users.xlsx").usersUpload(users);
        printArray(users);

    }

    public static void printArray(User[] users) {
        System.out.println("Массив пользователей: ");
        for (User user : users) {
            System.out.println(user);
        }
    }

    static User[] createUserArray() {
        while (true) {
            System.out.println("Выберите способ заполнения массива:");
            System.out.println("1. Случайно");
            System.out.println("2. Вручную");
            System.out.println("3. Из файла");
            System.out.println("Ваш выбор: ");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");
            int size = InputScanner.getIntInput("Введите размер массива: ");
            User[] users = new User[size];
            switch (choice) {
                case 1:
                    fillArrayRandomly(users);
                    break;
                case 2:
                    fillArrayManually(users);
                    break;
                case 3:
                    fillArrayFromFile(users);
                    break;
                default:
                    System.out.println("Неверный выбор. Заполняем случайно.");
                    fillArrayRandomly(users);
            }
            return users;
        }
    }

    private static String getSearchKey() {
        return InputScanner.getStringInput("Введите имя пользователя для поиска: ");
    }

}
