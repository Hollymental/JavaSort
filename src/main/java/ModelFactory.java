import java.util.Random;

public class ModelFactory {
    private static final Random random = new Random();

    private static String[] randomNames = new String[]{"James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda", "William", "Elizabeth", "David", "Barbara", "Richard", "Susan", "Joseph", "Jessica", "Charles", "Sarah", "Thomas", "Karen"};
    private static String[] randomPasswords = new String[]{"qwerty123", "asdfgh456", "zxcvbn789", "poiuyt321", "hjklmn654", "rtyuio987", "mnbvcx432", "qazwsx567", "plmokn098", "asdfghjkl", "qwertyuiop", "zxcvbnm123", "hjklqwe456", "tyuiop789", "mnbvcxz321", "qwerty456", "asdf12345", "zxcvbnm678", "poiuytrewq", "lkjhgfdsa"};
    private static String[] randomEmails = new String[]{"user123@example.com", "random456@mail.com", "testuser789@yahoo.com", "sample.email1@gmail.com", "demo_user234@outlook.com", "example567@domain.com", "user.name8@webmail.com", "unique_email9@provider.com", "email_test10@service.com", "randomuser11@site.com", "user12@example.org", "test.email13@mail.ru", "demo_user14@inbox.com", "sample.email15@post.com", "example16@webservice.com", "user17@domain.org", "random18@provider.net", "test19@service.co", "unique20@webmail.net", "email21@example.net"};

    public static Bus createRandomBus() {
        return new Bus.BusBuilder()
                .setNumber(String.valueOf(random.nextInt(1000)))
                .setModel("Model-" + random.nextInt(10))
                .setMileage(random.nextInt(100000))
                .build();
    }

    public static Student createRandomStudent() {
        return new Student.StudentBuilder()
                .setGroupNumber("Group-" + random.nextInt(10))
                .setAverageScore(3 + random.nextDouble() * 2)
                .setRecordBookNumber(random.nextInt(10000))
                .build();
    }

    public static User createRandomUser() {
        return new User.UserBuilder()
                .setName(randomNames[random.nextInt(20)])
                .setPassword(randomPasswords[random.nextInt(20)])
                .setEmail(randomEmails[random.nextInt(20)])
                .build();
    }

    public static Bus createBus(String number, String model, int mileage) {
        return new Bus.BusBuilder()
                .setNumber(number)
                .setModel(model)
                .setMileage(mileage)
                .build();
    }

    public static Student createStudent(String groupNumber, double averageGrade, Integer studentBookNumber) {
        return new Student.StudentBuilder()
                .setGroupNumber(groupNumber)
                .setAverageScore(averageGrade)
                .setRecordBookNumber(studentBookNumber)
                .build();
    }

    public static User createUser(String name, String password, String email) {
        return new User.UserBuilder()
                .setName(name)
                .setPassword(password)
                .setEmail(email)
                .build();
    }
}
