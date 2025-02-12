package Main;

import Camparators.CompositeComparator;
import Camparators.StudentComparators;
import Clases.ModelFactory;
import Clases.Student;
import Sorting.QuickSortWithStrategy;
import Validation.InputScanner;

public class ForStudent {

    public static void run(String[] args) {

        Student[] students = createStudentArray();
        processStudents(students);
    }

    private static void processStudents(Student[] students) {
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
                    QuickSortWithStrategy<Student> studentQuickSortWithStrategy = new QuickSortWithStrategy<>
                            (new CompositeComparator<>(
                                    new StudentComparators.SortByGroupNumber(),
                                    new StudentComparators.SortByAverageScore(),
                                    new StudentComparators.SortByRecordBookNumber()
                            ));
                    studentQuickSortWithStrategy.sort(students);
                    break;
                case 2:
                    chooseCustomSort(students);
                    break;
                case 3:
                    studentBinarySearch(students);
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void studentBinarySearch(Student[] students) {
        QuickSortWithStrategy<Student> studentQuickSortWithStrategy = new QuickSortWithStrategy<>
                (new CompositeComparator<>(
                        new StudentComparators.SortByGroupNumber(),
                        new StudentComparators.SortByAverageScore(),
                        new StudentComparators.SortByRecordBookNumber()
                ));
        studentQuickSortWithStrategy.sort(students);
//        SearchService<Clases.Student> searchService = new SearchService<>();
//        searchService.printSearchResult(students, getSearchKey());
    }

    private static void chooseCustomSort(Student[] students) {
        while (true) {
            System.out.println("Выберите по каким параметрам сортировать (можно несколько до 2 параметров):\n" +
                    "1.  По номеру группы\n" +
                    "2.  По среднему балу\n" +
                    "3.  По номеру зачетной книжки\n" +
                    "0.  Выход");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");

            switch (choice) {
                case 0:
                    return;
                case 1:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByGroupNumber())).sort(students);
                    break;
                case 2:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByAverageScore())).sort(students);
                    break;
                case 3:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByRecordBookNumber())).sort(students);
                    break;
                case 12:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByGroupNumber(), new StudentComparators.SortByAverageScore())).sort(students);
                    break;
                case 13:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByGroupNumber(), new StudentComparators.SortByRecordBookNumber())).sort(students);
                    break;
                case 21:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByAverageScore(), new StudentComparators.SortByGroupNumber())).sort(students);
                    break;
                case 23:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByAverageScore(), new StudentComparators.SortByRecordBookNumber())).sort(students);
                    break;
                case 31:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByRecordBookNumber(), new StudentComparators.SortByGroupNumber())).sort(students);
                    break;
                case 32:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new StudentComparators.SortByRecordBookNumber(), new StudentComparators.SortByAverageScore())).sort(students);
                    break;

                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void fillArrayRandomly(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            students[i] = ModelFactory.createRandomStudent();
        }
        printArray(students);
    }

    private static void fillArrayManually(Student[] students) {
        for (int i = 0; i < students.length; i++) {

            students[i] = ModelFactory.createStudent(
                    InputScanner.getStudentGroupInput("Номер группы: "),
                    InputScanner.getDoubleInput("Средний бал: "),
                    InputScanner.getStudentBookNumberInput("Номер зачетной книжки: "));;
            if (students[i]==null) {
                i--;
            }
        }
        printArray(students);
    }

    private static void fillArrayFromFile(Student[] students) {
        students = new FileUpload("students.xlsx").studentsUpload(students);
        printArray(students);
    }

    public static void printArray(Student[] students) {
        System.out.println("Массив студентов: ");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    static Student[] createStudentArray() {
        while (true) {
            System.out.println("Выберите способ заполнения массива:");
            System.out.println("1. Случайно");
            System.out.println("2. Вручную");
            System.out.println("3. Из файла");
            System.out.println("Ваш выбор: ");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");
            int size = InputScanner.getIntInput("Введите размер массива: ");
            Student[] students = new Student[size];
            switch (choice) {
                case 1:
                    fillArrayRandomly(students);
                    break;
                case 2:
                    fillArrayManually(students);
                    break;
                case 3:
                    fillArrayFromFile(students);
                    break;
                default:
                    System.out.println("Неверный выбор. Заполняем случайно.");
                    fillArrayRandomly(students);
            }
            return students;
        }
    }

    private static String getSearchKey() {
        return InputScanner.getStringInput("Введите номер автобуса для поиска: ");
    }

}
