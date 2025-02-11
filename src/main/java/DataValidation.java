public class DataValidation {
    private DataType dataType;

    public DataValidation(int dataType) {
        if (dataType == 1) {
            this.dataType = DataType.BUS;
        } else if (dataType == 2) {
            this.dataType = DataType.USER;
        } else if (dataType == 3) {
            this.dataType = DataType.STUDENT;
        } else {
            System.out.println("Неверный ввод");
            this.dataType = null;
        }
    }

    public DataValidation(DataType dataType) {
        this.dataType = dataType;
    }

    public boolean validation(String[] text) {
        return switch (this.dataType) {
            case DataType.BUS -> busValidation(text);
            case DataType.USER -> userValidation(text);
            case DataType.STUDENT -> studentValidation(text);
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

    boolean studentValidation(String[] text) {
        String groupNumber = text[0];
        double averageScore = Double.parseDouble(text[1]);
//        int recordBookNumber = Integer.parseInt(text.get(2));
        String recordBookNumber = text[2];
        return recordBookNumber.matches("[0-9]{5}$")
                && averageScore >= 0
                && averageScore <= 5;
    }

    boolean userValidation(String[] text) {
//        String name = text[0];
//        String password = text[1];
        String email = text[2];

        return email.matches("^[\\w-]+@[\\w-]+(\\.[\\w-]+)*\\.[a-z]{2,}$");
    }
}


