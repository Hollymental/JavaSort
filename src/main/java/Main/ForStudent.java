package Main;

import BinarySearch.SearchService;
import Comparators.CompositeComparator;
import Comparators.StudentComparators;
import Classes.ModelFactory;
import Classes.Student;
import Filework.FileDownload;
import Filework.FileUpload;
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
                    "4.  Сохранить полученный массив в файл\n" +
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
                case 4:
                    FileDownload fileDownload = new FileDownload("sortedstudents.xlsx");
                    fileDownload.createStudentFile(students);
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
                        new StudentComparators.SortByRecordBookNumber(),
                        new StudentComparators.SortByGroupNumber(),
                        new StudentComparators.SortByAverageScore()
                ));
        studentQuickSortWithStrategy.sort(students);
        SearchService<Student> searchService = new SearchService<Student>();
        searchService.printSearchResult(students, getSearchKey());
    }

    private static void chooseCustomSort(Student[] students) {
        while (true) {
            System.out.println("Выберите по каким параметрам сортировать (можно выбрать до 3 параметров):\n" +
                    "1.  По номеру группы\n" +
                    "2.  По среднему балу\n" +
                    "3.  По номеру зачетной книжки\n" +
                    "4.  По номеру зачетной книжки (только чётные)\n" +
                    "5.  Сохранить полученный массив в файл\n" +
                    "0.  Выход");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");
            QuickSortWithStrategy<Student> qs = new QuickSortWithStrategy<>();


            switch (choice) {
                case 0:
                    return;
                case 1:
                    qs.setStrategy(new CompositeComparator<>(new StudentComparators.SortByGroupNumber()));
                    qs.sort(students);
                    break;
                case 2:
                    qs.setStrategy(new CompositeComparator<>(new StudentComparators.SortByAverageScore()));
                    qs.sort(students);
                    break;
                case 3:
                    qs.setStrategy(new CompositeComparator<>(new StudentComparators.SortByRecordBookNumber()));
                    qs.sort(students);
                    break;
                case 4:
                    EvenStudentResult evenStudentResult = fillEvenStudentArray(students);
                    qs.setStrategy(new CompositeComparator<>(new StudentComparators.SortByRecordBookNumber()));
                    qs.evenSort(students, evenStudentResult.evenStudents, evenStudentResult.evenIndices);
                    break;
                case 5:
                    FileDownload fileDownload = new FileDownload("sortedstudents.xlsx");
                    fileDownload.createStudentFile(students);
                    break;
                case 12:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByGroupNumber(), new StudentComparators.SortByAverageScore()));
                    qs.sort(students);
                    break;
                case 13:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByGroupNumber(), new StudentComparators.SortByRecordBookNumber()));
                    qs.sort(students);
                    break;
                case 21:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByAverageScore(), new StudentComparators.SortByGroupNumber()));
                    qs.sort(students);
                    break;
                case 23:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByAverageScore(), new StudentComparators.SortByRecordBookNumber()));
                    qs.sort(students);
                    break;
                case 31:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByRecordBookNumber(), new StudentComparators.SortByGroupNumber()));
                    qs.sort(students);
                    break;
                case 32:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByRecordBookNumber(), new StudentComparators.SortByAverageScore()));
                    qs.sort(students);
                    break;
                case 123:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByGroupNumber(),
                            new StudentComparators.SortByAverageScore(),
                            new StudentComparators.SortByRecordBookNumber()));
                    qs.sort(students);
                    break;
                case 132:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByGroupNumber(),
                            new StudentComparators.SortByRecordBookNumber(),
                            new StudentComparators.SortByAverageScore()));
                    qs.sort(students);
                    break;
                case 213:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByAverageScore(),
                            new StudentComparators.SortByGroupNumber(),
                            new StudentComparators.SortByRecordBookNumber()));
                    qs.sort(students);
                    break;
                case 231:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByAverageScore(),
                            new StudentComparators.SortByRecordBookNumber(),
                            new StudentComparators.SortByGroupNumber()));
                    qs.sort(students);
                    break;
                case 312:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByRecordBookNumber(),
                            new StudentComparators.SortByGroupNumber(),
                            new StudentComparators.SortByAverageScore()));
                    qs.sort(students);
                    break;
                case 321:
                    qs.setStrategy(new CompositeComparator<>(
                            new StudentComparators.SortByRecordBookNumber(),
                            new StudentComparators.SortByAverageScore(),
                            new StudentComparators.SortByGroupNumber()));
                    qs.sort(students);
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
                    InputScanner.getStudentBookNumberInput("Номер зачетной книжки: "));
            ;
            if (students[i] == null) {
                i--;
            }
        }
        printArray(students);
    }

    private static void fillArrayFromFile(Student[] students) {
        students = new FileUpload("students.xlsx").studentsUpload(students);
        printArray(students);
    }

    static EvenStudentResult fillEvenStudentArray(Student[] students) {
        int evenCount = 0; //количество чётных элементов
        for (Student student : students) {
            if (student.getRecordBookNumber() % 2 == 0) {
                evenCount++;
            }
        }
        Student[] evenStudents = new Student[evenCount]; //массив чётных автобусов
        int currentIndex = 0; //текущий чётный элемент
        int[] evenIndices = new int[evenCount]; //индексы чётных элементов в изначальном массиве
        for (int i = 0; i < students.length; i++) {
            if (students[i].getRecordBookNumber() % 2 == 0) {
                evenStudents[currentIndex] = students[i];
                evenIndices[currentIndex] = i;
                currentIndex++;
            }
        }
        return new EvenStudentResult(evenStudents, evenIndices);
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
        return InputScanner.getStringInput("Введите номер зачетной книжки для поиска: ");
    }

    static class EvenStudentResult {
        Student[] evenStudents;
        int[] evenIndices;

        EvenStudentResult(Student[] evenStudents, int[] evenIndices) {
            this.evenStudents = evenStudents;
            this.evenIndices = evenIndices;
        }
    }
}
