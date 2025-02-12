import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите тип данных для сортировки:");
            System.out.println("1. Автобусы");
            System.out.println("2. Студенты");
            System.out.println("3. Пользователи");
            System.out.println("0. Выход");

            System.out.println("Ваш выбор: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    ForBus.run(args);
                    break;
                case 2:
                    ForStudent.run(args);
                    break;
                case 3:
                    //  ForUser.run(args);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
