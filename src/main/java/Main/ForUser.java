package Main;

import BinarySearch.SearchService;
import Comparators.CompositeComparator;
import Comparators.UserComparators;
import Classes.ModelFactory;
import Classes.User;
import Filework.FileDownload;
import Filework.FileUpload;
import Sorting.QuickSortWithStrategy;
import Validation.InputScanner;

public class ForUser {
    public static void run(String[] args) {

        User[] users = createUserArray();
        processUsers(users);
    }


    private static void processUsers(User[] users) {
        while (true) {
            System.out.println("""
                    Ваш выбор:
                    1.  Быстрая сортировка
                    2.  Кастомная сортировка
                    3.  Бинарный поиск
                    4.  Сохранить полученный массив в файл
                    0.  Выход.""");
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
                case 4:
                    FileDownload fileDownload = new FileDownload("sortedusers.xlsx");
                    fileDownload.createUserFile(users);
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
        SearchService<User> searchService = new SearchService<User>();
        searchService.printSearchResult(users, getSearchKey());
    }

    private static void chooseCustomSort(User[] users) {
        while (true) {

            System.out.println("Выберите по каким параметрам сортировать (можно выбрать до 3 параметров):\n" +
                    "1.  По имени\n" +
                    "2.  По паролю\n" +
                    "3.  По email\n" +
                    "4.  По хэш-коду (только чётные)\n" +
                    "5.  Сохранить полученный массив в файл\n" +
                    "0.  Выход");

            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");
            QuickSortWithStrategy<User> qs = new QuickSortWithStrategy<>();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    qs.setStrategy(new CompositeComparator<>(new UserComparators.SortByName()));
                    qs.sort(users);
                    break;
                case 2:
                    qs.setStrategy(new CompositeComparator<>(new UserComparators.SortByPassword()));
                    qs.sort(users);
                    break;
                case 3:
                    qs.setStrategy(new CompositeComparator<>(new UserComparators.SortByEmail()));
                    qs.sort(users);
                    break;
                case 4:
                    EvenUserResult evenUserResult = fillEvenUserArray(users);
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByHashCode()));
                    qs.evenSort(users, evenUserResult.evenUsers, evenUserResult.evenIndices);
                    break;
                case 5:
                    FileDownload fileDownload = new FileDownload("sortedusers.xlsx");
                    fileDownload.createUserFile(users);
                    break;
                case 12:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByName(), new UserComparators.SortByPassword()));
                    qs.sort(users);
                    break;
                case 13:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByName(), new UserComparators.SortByEmail()));
                    qs.sort(users);
                    break;
                case 21:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByPassword(), new UserComparators.SortByName()));
                    qs.sort(users);
                    break;
                case 23:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByPassword(), new UserComparators.SortByEmail()));
                    qs.sort(users);
                    break;
                case 31:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByEmail(), new UserComparators.SortByName()));
                    qs.sort(users);
                    break;
                case 32:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByEmail(), new UserComparators.SortByPassword()));
                    qs.sort(users);
                    break;
                case 123:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByName(),
                            new UserComparators.SortByPassword(),
                            new UserComparators.SortByEmail()));
                    qs.sort(users);
                    break;
                case 132:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByName(),
                            new UserComparators.SortByEmail(),
                            new UserComparators.SortByPassword()));
                    qs.sort(users);
                    break;
                case 213:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByPassword(),
                            new UserComparators.SortByName(),
                            new UserComparators.SortByEmail()));
                    qs.sort(users);
                    break;
                case 231:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByPassword(),
                            new UserComparators.SortByEmail(),
                            new UserComparators.SortByName()));
                    qs.sort(users);
                    break;
                case 312:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByEmail(),
                            new UserComparators.SortByName(),
                            new UserComparators.SortByPassword()));
                    qs.sort(users);
                    break;
                case 321:
                    qs.setStrategy(new CompositeComparator<>(
                            new UserComparators.SortByEmail(),
                            new UserComparators.SortByPassword(),
                            new UserComparators.SortByName()));
                    qs.sort(users);
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
            if (users[i] == null) {
                i--;
            }
        }
        printArray(users);
    }

    private static void fillArrayFromFile(User[] users) {
        users = new FileUpload("users.xlsx").usersUpload(users);
        printArray(users);

    }

    static EvenUserResult fillEvenUserArray(User[] users) {
        int evenCount = 0; //количество чётных элементов
        for (User user : users) {
            if (user.hashCode() % 2 == 0) {
                evenCount++;
            }
        }
        User[] evenUsers = new User[evenCount]; //массив чётных пользователей
        int currentIndex = 0; //текущий чётный элемент
        int[] evenIndices = new int[evenCount]; //индексы чётных элементов в изначальном массиве
        for (int i = 0; i < users.length; i++) {
            if (users[i].hashCode() % 2 == 0) {
                evenUsers[currentIndex] = users[i];
                evenIndices[currentIndex] = i;
                currentIndex++;
            }
        }
        return new EvenUserResult(evenUsers, evenIndices);
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

    static class EvenUserResult {
        User[] evenUsers;
        int[] evenIndices;

        EvenUserResult(User[] evenUsers, int[] evenIndices) {
            this.evenUsers = evenUsers;
            this.evenIndices = evenIndices;
        }
    }
}
