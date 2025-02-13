package Validation;

import Classes.Bus;
import Classes.Student;
import Classes.User;

public class DataValidation {
    private Class<?> dataType;

    public DataValidation(Class<?> dataType) {
        this.dataType = dataType;
    }

    public boolean validation(String[] text) {
        if (this.dataType == Bus.class)
            return busValidation(text);
        else if (this.dataType == User.class)
            return userValidation(text);
        else if (this.dataType == Student.class)
            return studentValidation(text);
        else
            return false;
    }

    public boolean busValidation(String[] text) {
        String number = text[0];
        String model = text[1];
        int mileage = 0;
        try {
            mileage = Integer.parseInt(text[2]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return 0 <= mileage && mileage <= 999999
                && model.matches("^Model-[0-9]$")
                && number.matches("^[0-9]{3}$");
    }

    public boolean studentValidation(String[] text) {
        String groupNumber = text[0];
        double averageScore = Double.parseDouble(text[1]);
        String recordBookNumber = text[2];
        return recordBookNumber.matches("^[0-9]{4}$")
                && averageScore >= 0
                && averageScore <= 10
                && groupNumber.matches("^Group-[0-9]$");
    }

    public boolean userValidation(String[] text) {
        String email = text[2];
        return email.matches("^[\\.\\w-]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
}


