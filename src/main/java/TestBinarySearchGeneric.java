public class TestBinarySearchGeneric<T extends Comparable<T>> {

    public int binarySearch(T[] arr, T key) {
        if (arr == null || arr.length == 0) {
            System.out.println("пустой массив! Элемент не найден ");
            return -1;
        }

        //quick_sort(arr); // Здесь вызов сортировки, если массив еще не был отсортирован

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Предотвращает переполнение для больших массивов

            int comparisonResult = arr[mid].compareTo(key);

            if (comparisonResult == 0) {
                System.out.println("Объект " + arr[mid] + " найден, индекс объекта: ");
                return  mid; // Элемент найден
            } else if (comparisonResult < 0) {
                low = mid + 1; // Ключ больше, ищем в правой половине
            } else {
                high = mid - 1; // Ключ меньше, ищем в левой половине
            }
        }
        System.out.println("Объект не найден");
        return -1;
    }


    public static void main(String[] args) {  //Тестирование классов
        Bus[] busArr = {new Bus("123", "lyaz", 12000),
                new Bus("200", "paz", 100000),
                new Bus("300", "ikarus", 00000),
                new Bus("400", "ikarus", 600000)};

        TestBinarySearchGeneric<Bus> busSearch = new TestBinarySearchGeneric<>();
        System.out.println(busSearch.binarySearch(busArr, new Bus("200", "paz", 100000)));
        System.out.println(busSearch.binarySearch(busArr, new Bus("300", "ikarus", 00000)));
        System.out.println(busSearch.binarySearch(busArr, new Bus("400", "ikarus", 600000)));

        //Тестирование класса Student
        System.out.println("Тест класса Student: ");
        Student[] studentArr = {new Student("1", 1.0, "110"),
                new Student("2", 5.5, "111"),
                new Student("2", 4.2, "112"),
                new Student("3", 2.1, "113"),
                new Student("4", 3, "114")};

        TestBinarySearchGeneric<Student> studentSearch = new TestBinarySearchGeneric<>();
        System.out.println(studentSearch.binarySearch(studentArr, new Student("4", 3, "114")));
        System.out.println(studentSearch.binarySearch(studentArr, new Student("2", 4.3, "112")));
        System.out.println(studentSearch.binarySearch(studentArr, new Student("1", 1.0, "110")));
    }
}