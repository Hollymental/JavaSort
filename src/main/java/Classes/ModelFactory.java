package Classes;

import Validation.DataValidation;

import java.util.Random;

public class ModelFactory {
    private static final Random random = new Random();

    private static String[] randomNames = new String[]{"James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda", "William", "Elizabeth", "David", "Barbara", "Richard", "Susan", "Joseph", "Jessica", "Charles", "Sarah", "Thomas", "Karen"};
    private static String[] randomPasswords = new String[]{"qwerty123", "asdfgh456", "zxcvbn789", "poiuyt321", "hjklmn654", "rtyuio987", "mnbvcx432", "qazwsx567", "plmokn098", "asdfghjkl", "qwertyuiop", "zxcvbnm123", "hjklqwe456", "tyuiop789", "mnbvcxz321", "qwerty456", "asdf12345", "zxcvbnm678", "poiuytrewq", "lkjhgfdsa"};
    private static String[] randomEmails = new String[]{"user123@example.com", "random456@mail.com", "testuser789@yahoo.com", "sample.email1@gmail.com", "demo_user234@outlook.com", "example567@domain.com", "user.name8@webmail.com", "unique_email9@provider.com", "email_test10@service.com", "randomuser11@site.com", "user12@example.org", "test.email13@mail.ru", "demo_user14@inbox.com", "sample.email15@post.com", "example16@webservice.com", "user17@domain.org", "random18@provider.net", "test19@service.co", "unique20@webmail.net", "email21@example.net"};

    public static Bus createRandomBus() {
        String number = String.valueOf(random.nextInt(100, 1000));
        String model = "Model-" + random.nextInt(10);
        int mileage = random.nextInt(1000000);

        DataValidation dataValidation = new DataValidation(Bus.class);
        boolean isValid = dataValidation.validation(new String[]{number, model, String.valueOf(mileage)});
        if (isValid) {
            return new Bus.BusBuilder()
                    .setNumber(number)
                    .setModel(model)
                    .setMileage(mileage)
                    .build();
        } else {
            System.out.println("Данные не валидны:");
            System.out.println(number + " " + model + " " + mileage + "\n");
            return null;
        }
    }

    public static Student createRandomStudent() {
        String groupNumber = "Group-" + random.nextInt(10);
        double averageScore = 3 + random.nextDouble() * 2;
        int recordBookNumber = random.nextInt(1000, 10000);

        DataValidation dataValidation = new DataValidation(Student.class);
        boolean isValid = dataValidation.validation(new String[]{groupNumber, String.valueOf(averageScore), String.valueOf(recordBookNumber)});
        if (isValid) {
            return new Student.StudentBuilder()
                    .setGroupNumber(groupNumber)
                    .setAverageScore(averageScore)
                    .setRecordBookNumber(recordBookNumber)
                    .build();
        } else {
            System.out.println("Данные не валидны");
            System.out.println(groupNumber + " " + averageScore + " " + recordBookNumber + " ");
            return null;
        }
    }

    public static User createRandomUser() {

        String name = randomNames[random.nextInt(20)];
        String password = randomPasswords[random.nextInt(20)];
        String email = randomEmails[random.nextInt(20)];

        DataValidation dataValidation = new DataValidation(User.class);
        boolean isValid = dataValidation.validation(new String[]{name, password, email});
        if (isValid) {
            return new User.UserBuilder()
                    .setName(name)
                    .setPassword(password)
                    .setEmail(email)
                    .build();
        } else {
            System.out.println("Данные не валидны:");
            System.out.println(name + " " + password + " " + email + "\n");
            return null;
        }
    }

    public static Bus createBus(String number, String model, int mileage) {
        DataValidation dataValidation = new DataValidation(Bus.class);
        boolean isValid = dataValidation.validation(new String[]{number, model, String.valueOf(mileage)});
        if (isValid) {

            return new Bus.BusBuilder()
                    .setNumber(number)
                    .setModel(model)
                    .setMileage(mileage)
                    .build();
        } else {
            System.out.println("Введенные данные не валидны");
            System.out.println(number + " " + model + " " + mileage + "\n");
            return null;
        }
    }

    public static Student createStudent(String groupNumber, double averageGrade, Integer studentBookNumber) {
        DataValidation dataValidation = new DataValidation(Student.class);
        boolean isValid = dataValidation.validation(new String[]{groupNumber, String.valueOf(averageGrade), String.valueOf(studentBookNumber)});
        if (isValid) {
            return new Student.StudentBuilder()
                    .setGroupNumber(groupNumber)
                    .setAverageScore(averageGrade)
                    .setRecordBookNumber(studentBookNumber)
                    .build();
        } else {
            System.out.println("Введенные данные не валидны");
            System.out.println(groupNumber + " " + averageGrade + " " + studentBookNumber + " ");
            return null;
        }
    }

    public static User createUser(String name, String password, String email) {
        DataValidation dataValidation = new DataValidation(User.class);
        boolean isValid = dataValidation.validation(new String[]{name, password, email});
        if (isValid) {
            return new User.UserBuilder()
                    .setName(name)
                    .setPassword(password)
                    .setEmail(email)
                    .build();
        } else {
            System.out.println("Введенные данные не валидны");
            System.out.println(name + " " + password + " " + email + "\n");
            return null;
        }
    }
}
