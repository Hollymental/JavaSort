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

    public static boolean isPositiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
