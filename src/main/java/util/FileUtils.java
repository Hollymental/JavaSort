package util;

import java.io.*;


public class FileUtils {
//    private static final int MAX_LINES = 1000;  // Максимальное количество строк, которые мы можем хранить
//
//    public static <T> T[] readFromFile(String fileName, LineParser<T> parser) throws IOException {
//        T[] result = (T[]) new Object[MAX_LINES]; // Создаем массив фиксированного размера
//        int count = 0; // Счетчик загруженных элементов
//
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))) {
//            String line;
//            while ((line = br.readLine()) != null && count < MAX_LINES) {
//                result[count] = parser.parse(line); // Парсим строку и добавляем в массив
//                count++; // Увеличиваем счетчик
//            }
//        }
//
//        // Создаем итоговый массив нужного размера
//        T[] finalResult = (T[]) new Object[count];
//        System.arraycopy(result, 0, finalResult, 0, count); // Копируем только заполненные элементы
//        return finalResult; // Возвращаем массив
//    }
//
//    public static <T> void writeToFile(String fileName, T[] data, boolean append) throws IOException {
//        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName, append))) {
//            for (T item : data) {
//                writer.println(item.toString()); // Записываем строковое представление объекта
//            }
//        }
//    }
//
//    public interface LineParser<T> {
//        T parse(String line);
//    }
}
