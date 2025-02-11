import java.util.ArrayList;
import java.util.Scanner;

public class DataValidation {
    private final int dataType;

    public DataValidation(int dataType) {
        this.dataType = dataType;
    }

    public boolean validation() {
        ArrayList<String> text = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(" ");
        while (scanner.hasNext()) {
            text.add(scanner.nextLine());
        }

        return switch (this.dataType) {
            case 1 -> busValidation(text);
            case 2 -> userValidation(text);
            case 3 -> studentValidation(text);
            default -> false;
        };
    }

    boolean busValidation(ArrayList<String> text) {
        String number = text.get(0);
        String model = text.get(1);
        int mileage = Integer.parseInt(text.get(2));
//        } catch (NumberFormatException nfe) {
//            System.out.println("NumberFormatException: " + nfe.getMessage());
//        }
        return 0 < mileage && mileage < 999999;
    }

    boolean studentValidation (ArrayList<String> text) {
        String groupNumber = text.get(0);
        double averageScore = 0;
//        int recordBookNumber = Integer.parseInt(text.get(2));
        String recordBookNumber = text.get(2);
        return recordBookNumber.matches("[0-9]{5}$");
    }

    boolean userValidation(ArrayList<String> text) {
//        String name = text.get(0);
//        String password = text.get(1);
        String email = text.get(2);

        return email.matches("^[\\w-]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
}
