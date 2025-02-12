import org.apache.poi.ss.formula.functions.T;

public class DataValidation {
    private Class<?> dataType;

    public DataValidation(int dataType) {
        if (dataType == 1) {
            this.dataType = Bus.class;
        } else if (dataType == 2) {
            this.dataType = User.class;
        } else if (dataType == 3) {
            this.dataType = Student.class;
        } else {
            System.out.println("Неверный ввод");
            this.dataType = null;
        }
    }

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
            mileage = (int) Double.parseDouble(text[2]);
//            mileage = Integer.parseInt(text[2]);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return 0 < mileage && mileage < 999999
                && model.matches("^Model-[0-9]$")
                && number.matches("^[0-9][0-9][0-9]$");
    }

    public boolean studentValidation(String[] text) {

//        System.out.println(text[0] + " " + text[1] + " " + text[2]);
        String groupNumber = text[0];
        double averageScore = Double.parseDouble(text[1]);
//        int recordBookNumber = (int) Double.parseDouble(text[2]);
        int recordBookNumber = 0;
        String recordBookNumberStr = "";
        try {
            recordBookNumber = (int) Double.parseDouble(text[2]);
//            mileage = Integer.parseInt(text[2]);
            recordBookNumberStr = String.valueOf(recordBookNumber);
        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }
        return recordBookNumberStr.matches("^[0-9]{5}$")
                && averageScore >= 0
                && averageScore <= 10;
    }

    public boolean userValidation(String[] text) {
//        String name = text[0];
//        String password = text[1];
        String email = text[2];

        return email.matches("^[\\w-]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
}


