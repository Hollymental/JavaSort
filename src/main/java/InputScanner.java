import java.util.Scanner;

public class InputScanner {

    static Scanner scanner = new Scanner(System.in);

    static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (isPositiveInteger(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("Пожалуйста, введите положительное целое число.");
        }
    }

    static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }

    static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.next());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректное число.");
            }
        }
    }

    static String getBusNumberInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (input.matches("^[0-9]{3}$")) {
                return input;
            }
            System.out.println("Пожалуйста, введите номер автобуса из 3х цифр.");
        }
    }

    static String getBusModelInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (input.matches("^Model-[0-9]$")) {
                return input;
            }
            System.out.println("Пожалуйста, введите модель автобуса в формате 'Model-X', где Х цифра.");
        }
    }

    static String getStudentGroupInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (input.matches("^Group-[0-9]$")) {
                return input;
            }
            System.out.println("Пожалуйста, введите группу студента в формате 'Group-X', где Х цифра.");
        }
    }

    static int getStudentBookNumberInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (input.matches("^[0-9]{4}$")) {
                return Integer.parseInt(input);
            }
            System.out.println("Пожалуйста, введите номер зачетной книжки студента из 4х цифр.");
        }
    }

    static String getUserEmail(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();
            if (input.matches("^Group-[0-9]$")) {
                return input;
            }
            System.out.println("Пожалуйста, введите email пользователя в формате 'example@.com'");
        }
    }

    public static boolean isPositiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
