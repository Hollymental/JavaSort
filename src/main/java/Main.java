import java.util.Scanner;

enum DataType {
    BUS,
    STUDENT,
    USER
}

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        /*
        ---------------
        3 строчки ниже вставить для считывания из файла
        ---------------
        User[] users = new FileUpload("users.xlsx").usersUpload();
        Bus[] buses = new FileUpload("buses.xlsx").busesUpload();
        Student[] students = new FileUpload("students.xlsx").studentsUpload();

        ---------------
        3 строчки ниже для проверки что все корректно считалось
        ---------------
        System.out.println(users[0].getName());
        System.out.println(buses[0].getNumber());
        System.out.println(students[0].getAverageScore());
        */
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
        System.out.println("Выберите размер:");
        int size = scanner.nextInt();
        Object[] array = new Object[size];
        switch (dataType) {

            case 1:
                Bus[] busArray = ArrayCreator.createArray("Автобусов", size, new BusHandler());
            for (Bus bus: busArray)
            {
                System.out.println(bus.toString());
            }
            break;
            case 2:
                User[] userArray = ArrayCreator.createArray("Пользователей", size, new UserHandler());
                for (User user: userArray)
                {
                    System.out.println(user.toString());
                }
                break;
            case 3:
                Student[] studentArray = ArrayCreator.createArray("Студентов", size, new StudentHandler());
                for (Student student: studentArray)
                {
                    System.out.println(student.toString());
                }
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }

                ;
//        String[] text = {"", "", ""};
/*
        ---------------
        Валидация введенных данных(text) по выбранному типу данных(dataType)
        ---------------

        DataValidation dataValidation = new DataValidation(dataType);
        boolean isValid = dataValidation.validation(text);
 */

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
class BusHandler implements ArrayCreator.ArrayHandler<Bus> {
    @Override
    public Bus[] createArray(int size) {
        return new Bus[size];
    }

    @Override
    public void fillArrayRandomly(Bus[] array, int size) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (Bus) ModelFactory.createRandomBus();
        }
    }

    @Override
    public void fillArrayManually(Bus[] array, int size) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите данные для элемента " + (i + 1) + ":");
            array[i] = (Bus) ModelFactory.createBus(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextInt());
        }
    }

    @Override
    public void fillArrayFromFile(Bus[] array, int size) {

        Bus[] buses = new FileUpload("buses.xlsx").busesUpload();
    }
}

class UserHandler implements ArrayCreator.ArrayHandler<User> {
    @Override
    public User[] createArray(int size) {
        return new User[size];
    }

    @Override
    public void fillArrayRandomly(User[] array, int size) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (User) ModelFactory.createRandomUser();
        }
    }

    @Override
    public void fillArrayManually(User[] array, int size) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите данные для элемента " + (i + 1) + ":");
            array[i] = (User) ModelFactory.createUser(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine());
        }
    }

    @Override
    public void fillArrayFromFile(User[] array, int size) {
        User[] users = new FileUpload("users.xlsx").usersUpload();

    }
}

class StudentHandler implements ArrayCreator.ArrayHandler<Student> {
    @Override
    public Student[] createArray(int size) {
        return new Student[size];
    }

    @Override
    public void fillArrayRandomly(Student[] array, int size) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (Student) ModelFactory.createRandomStudent();
        }
    }

    @Override
    public void fillArrayManually(Student[] array, int size) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите данные для элемента " + (i + 1) + ":");
            array[i] = (Student) ModelFactory.createStudent(
                    scanner.nextLine(),
                    scanner.nextInt(),
                    scanner.nextInt());
        }
    }

    @Override
    public void fillArrayFromFile(Student[] array, int size) {

        Student[] students = new FileUpload("students.xlsx").studentsUpload();
    }
}
