import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        FileUpload fileUpload = new FileUpload("users.xlsx");

//        User[] users = new FileUpload("users.xlsx").usersUpload();
//        Bus[] buses = new FileUpload("buses.xlsx").busesUpload();
//        Student[] students = new FileUpload("students.xlsx").studentsUpload();
//        fileUpload.dataUpload();
        System.out.println(users[0].getName());
        while (!exit) {
            System.out.println("Добро пожаловать в программу сортировки.");
            System.out.println("Выберите действие:");
            System.out.println("1. Создать массив данных");
            System.out.println("2. Сортировать данные");
            System.out.println("3. Выполнить бинарный поиск");
            System.out.println("4. Выйти");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createData(scanner);
                    break;
                case 2:
                    sortData(scanner);
                    break;
                case 3:
                    performBinarySearch(scanner);
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте снова.");
            }
        }

        scanner.close();
    }

    private static void createData(Scanner scanner) {
        System.out.println("Выберите тип данных для создания:");
        System.out.println("1. Автобус");
        System.out.println("2. Пользователь");
        System.out.println("3. Студент");

        int dataType = scanner.nextInt();

        String[] text = {"", "", ""};
        DataValidation dataValidation = new DataValidation(dataType);
        boolean isValid = dataValidation.validation(text);
        // Логика конструктора классов
    }

    private static void sortData(Scanner scanner) {
        System.out.println("Выберите алгоритм сортировки:");
        System.out.println("1. Быстрая сортировка");

        int sortType = scanner.nextInt();
        // Логика сортировки
    }

    private static void performBinarySearch(Scanner scanner) {
        // Логика выполнения бинарного поиска
        System.out.println("Введите элемент для поиска:");
    }
}
