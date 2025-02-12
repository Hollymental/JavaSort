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
    //    SearchService<Bus> searchService = new SearchService<>();
    //    searchService.printSearchResult(buses, getSearchKey());
    }

    private static void chooseCustomSort(Bus[] buses) {
        while (true) {
            System.out.println("Выберите по каким параметрам сортировать (можно несколько до 2 параметров):\n" +
                    "1.  По номеру автобуса\n" +
                    "2.  По модели\n" +
                    "3.  По пробегу\n" +
                    "0.  Выход");
            int choice = InputScanner.getIntInput("Сделайте ваш выбор: ");

            switch (choice) {
                case 0:
                    return;
                case 1:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByNumber())).sort(buses);
                    break;
                case 2:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByModel())).sort(buses);
                    break;
                case 3:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByMileage())).sort(buses);
                    break;
                case 12:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByNumber(), new BusComporators.SortByModel())).sort(buses);
                    break;
                case 13:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByNumber(), new BusComporators.SortByMileage())).sort(buses);
                    break;
                case 21:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByModel(), new BusComporators.SortByNumber())).sort(buses);
                    break;
                case 23:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByModel(), new BusComporators.SortByMileage())).sort(buses);
                    break;
                case 31:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByMileage(), new BusComporators.SortByNumber())).sort(buses);
                    break;
                case 32:
                    new QuickSortWithStrategy<>(new CompositeComparator<>(
                            new BusComporators.SortByMileage(), new BusComporators.SortByModel())).sort(buses);
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
                    InputScanner.getStringInput("Номер: "),
                    InputScanner.getStringInput("Модель: "),
                    InputScanner.getIntInput("Пробег: "));
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

    private static String getSearchKey() {
        return InputScanner.getStringInput("Введите номер автобуса для поиска: ");
    }

}
