package Main;

import BinarySearch.SearchService;
import Comparators.BusComporators;
import Comparators.CompositeComparator;
import Classes.Bus;
import Classes.ModelFactory;
import Filework.FileDownload;
import Filework.FileUpload;
import Sorting.QuickSortWithStrategy;
import Validation.InputScanner;

public class ForBus {

    public static void run(String[] args) {

        Bus[] buses = createBusArray();
        processBuses(buses);
    }

    private static void processBuses(Bus[] buses) {
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
                    QuickSortWithStrategy<Bus> busQuickSortWithStrategy = new QuickSortWithStrategy<>
                            (new CompositeComparator<>(
                                    new BusComporators.SortByNumber(),
                                    new BusComporators.SortByModel(),
                                    new BusComporators.SortByMileage()
                            ));
                    busQuickSortWithStrategy.sort(buses);
                    break;
                case 2:
                    chooseCustomSort(buses);
                    break;
                case 3:
                    busBinarySearch(buses);
                    break;
                case 4:
                    FileDownload fileDownload = new FileDownload("sortedbuses.xlsx");
                    fileDownload.createBusFile(buses);
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void busBinarySearch(Bus[] buses) {
        QuickSortWithStrategy<Bus> busQuickSortWithStrategy = new QuickSortWithStrategy<>
                (new CompositeComparator<>(
                        new BusComporators.SortByNumber(),
                        new BusComporators.SortByModel(),
                        new BusComporators.SortByMileage()
                ));

        busQuickSortWithStrategy.sort(buses);
        SearchService<Bus> searchService = new SearchService<Bus>();
        searchService.printSearchResult(buses, getSearchKey());
    }

    private static void chooseCustomSort(Bus[] buses) {
        while (true) {
            System.out.println("Выберите по каким параметрам сортировать (можно выбрать до 3 параметров):\n" +
                    "1.  По номеру автобуса\n" +
                    "2.  По модели\n" +
                    "3.  По пробегу\n" +
                    "4.  По пробегу (только чётные)\n" +
                    "5.  Сохранить полученный массив в файл\n" +
                    "0.  Выход");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");
            QuickSortWithStrategy<Bus> qs = new QuickSortWithStrategy<>();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByNumber()));
                    qs.sort(buses);
                    break;
                case 2:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByModel()));
                    qs.sort(buses);
                    break;
                case 3:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByMileage()));
                    qs.sort(buses);
                    break;
                case 4:
                    EvenBusResult evenBusResult = fillEvenBusArray(buses);
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByMileage()));
                    qs.evenSort(buses, evenBusResult.evenBuses, evenBusResult.evenIndices);
                    break;
                case 5:
                    FileDownload fileDownload = new FileDownload("sortedbuses.xlsx");
                    fileDownload.createBusFile(buses);
                    break;
                case 12:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByNumber(), new BusComporators.SortByModel()));
                    qs.sort(buses);
                    break;
                case 13:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByNumber(), new BusComporators.SortByMileage()));
                    qs.sort(buses);
                    break;
                case 21:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByModel(), new BusComporators.SortByNumber()));
                    qs.sort(buses);
                    break;
                case 23:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByModel(), new BusComporators.SortByMileage()));
                    qs.sort(buses);
                    break;
                case 31:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByMileage(), new BusComporators.SortByNumber()));
                    qs.sort(buses);
                    break;
                case 32:
                    qs.setStrategy(new CompositeComparator<>(new BusComporators.SortByMileage(), new BusComporators.SortByModel()));
                    qs.sort(buses);
                    break;
                case 123:
                    qs.setStrategy(new CompositeComparator<>(
                            new BusComporators.SortByNumber(),
                            new BusComporators.SortByModel(),
                            new BusComporators.SortByMileage()));
                    qs.sort(buses);
                    break;
                case 132:
                    qs.setStrategy(new CompositeComparator<>(
                            new BusComporators.SortByNumber(),
                            new BusComporators.SortByMileage(),
                            new BusComporators.SortByModel()
                    ));
                    qs.sort(buses);
                case 213:
                    qs.setStrategy(new CompositeComparator<>(
                            new BusComporators.SortByModel(),
                            new BusComporators.SortByNumber(),
                            new BusComporators.SortByMileage()));
                    qs.sort(buses);
                    break;
                case 231:
                    qs.setStrategy(new CompositeComparator<>(
                            new BusComporators.SortByModel(),
                            new BusComporators.SortByMileage(),
                            new BusComporators.SortByNumber()));
                    qs.sort(buses);
                    break;
                case 312:
                    qs.setStrategy(new CompositeComparator<>(
                            new BusComporators.SortByMileage(),
                            new BusComporators.SortByNumber(),
                            new BusComporators.SortByModel()));
                    qs.sort(buses);
                    break;
                case 321:
                    qs.setStrategy(new CompositeComparator<>(
                            new BusComporators.SortByMileage(),
                            new BusComporators.SortByModel(),
                            new BusComporators.SortByNumber()));
                    qs.sort(buses);
                    break;

                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }

    private static void fillArrayRandomly(Bus[] buses) {
        for (int i = 0; i < buses.length; i++) {
            buses[i] = ModelFactory.createRandomBus();
        }
        printArray(buses);
    }

    private static void fillArrayManually(Bus[] buses) {
        for (int i = 0; i < buses.length; i++) {
            buses[i] = ModelFactory.createBus(
                    InputScanner.getBusNumberInput("Номер: "),
                    InputScanner.getBusModelInput("Модель: "),
                    InputScanner.getIntInput("Пробег: "));
            if (buses[i] == null) {
                i--;
            }
        }
        printArray(buses);
    }

    private static void fillArrayFromFile(Bus[] buses) {
        buses = new FileUpload("buses.xlsx").busesUpload(buses);
        printArray(buses);
    }

    public static void printArray(Bus[] buses) {
        System.out.println("Массив автобусов: ");
        for (Bus bus : buses) {
            System.out.println(bus);
        }
    }

    static Bus[] createBusArray() {
        while (true) {
            System.out.println("Выберите способ заполнения массива:");
            System.out.println("1. Случайно");
            System.out.println("2. Вручную");
            System.out.println("3. Из файла");
            System.out.println("Ваш выбор: ");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");
            int size = InputScanner.getIntInput("Введите размер массива: ");
            Bus[] buses = new Bus[size];
            switch (choice) {
                case 1:
                    fillArrayRandomly(buses);
                    break;
                case 2:
                    fillArrayManually(buses);
                    break;
                case 3:
                    fillArrayFromFile(buses);
                    break;
                default:
                    System.out.println("Неверный выбор. Заполняем случайно.");
                    fillArrayRandomly(buses);
            }
            return buses;
        }
    }

    static EvenBusResult fillEvenBusArray(Bus[] buses) {
        int evenCount = 0; //количество чётных элементов
        for (Bus bus : buses) {
            if (bus.getMileage() % 2 == 0) {
                evenCount++;
            }
        }
        Bus[] evenBuses = new Bus[evenCount]; //массив чётных автобусов
        int currentIndex = 0; //текущий чётный элемент
        int[] evenIndices = new int[evenCount]; //индексы чётных элементов в изначальном массиве
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getMileage() % 2 == 0) {
                evenBuses[currentIndex] = buses[i];
                evenIndices[currentIndex] = i;
                currentIndex++;
            }
        }
        return new EvenBusResult(evenBuses, evenIndices);
    }

    private static String getSearchKey() {
        return InputScanner.getStringInput("Введите номер автобуса для поиска: ");
    }

    static class EvenBusResult {
        Bus[] evenBuses;
        int[] evenIndices;

        EvenBusResult(Bus[] evenBuses, int[] evenIndices) {
            this.evenBuses = evenBuses;
            this.evenIndices = evenIndices;
        }
    }
}
