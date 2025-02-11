import java.util.ArrayList;
import java.util.Scanner;

public class DataValidation {
    private final int dataType;

    public DataValidation(int dataType) {
        this.dataType = dataType;
    }

    public boolean validation(String[] text) {
//        String[] text = {"", "", ""};
        return switch (this.dataType) {
            case 1 -> busValidation(text);
            case 2 -> userValidation(text);
            case 3 -> studentValidation(text);
            default -> false;
        };
    }

    boolean busValidation(String[] text) {
        String number = text[0];
        String model = text[1];
        int mileage = Integer.parseInt(text[2]);
//        } catch (NumberFormatException nfe) {
//            System.out.println("NumberFormatException: " + nfe.getMessage());
//        }
        return 0 < mileage && mileage < 999999;
    }

    boolean studentValidation (String[] text) {
        String groupNumber = text[0];
        double averageScore = 0;
//        int recordBookNumber = Integer.parseInt(text.get(2));
        String recordBookNumber = text[2];
        return recordBookNumber.matches("[0-9]{5}$");
    }

    boolean userValidation(String[] text) {
//        String name = text[0];
//        String password = text[1];
        String email = text[2];

        return email.matches("^[\\w-]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
}
