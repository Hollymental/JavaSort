import java.util.Scanner;

public class DataValidation {
    private final int dataType;

    public DataValidation(int dataType) {
        this.dataType = dataType;
    }

    public boolean validation() {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        return switch (this.dataType) {
            case 1 -> busValidation(text);
            case 2 -> userValidation(text);
            case 3 -> studentValidation(text);
            default -> false;
        };
    }

    boolean busValidation(String text) {

        return false;
    }

    boolean userValidation(String text) {

        return false;
    }

    boolean studentValidation(String text) {

        return false;
    }
}
