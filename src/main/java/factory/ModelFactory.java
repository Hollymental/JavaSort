package factory;

import java.util.Random;

public class ModelFactory {
    private static final Random random = new Random();
    static Faker dataFaker = new Faker();

    public static Bus createRandomBus() {
        return new Bus.BusBuilder()
                .setNumber(dataFaker.bothify("??####", true))
                .setModel("Model-" + random.nextInt(5))
                .setMileage(random.nextInt(100000))
                .build();
    }

    public static Student createRandomStudent() {
        return new Student.StudentBuilder()
                .setGroupNumber("Group-" + random.nextInt(5))
                .setAverageScore(3 + random.nextDouble() * 2)
                .setRecordBookNumber(dataFaker.bothify("B###", true))
                .build();
    }

    public static User createRandomUser() {
        return new User.UserBuilder()
                .setName(dataFaker.name().firstName())
                .setPassword(dataFaker.numerify("######"))
                .setEmail(dataFaker.bothify("###?@gmail.com"))
                .build();
    }


    public static Bus createBus(String number, String model, int mileage) {
        return new Bus.BusBuilder()
                .setNumber(number)
                .setModel(model)
                .setMileage(mileage)
                .build();
    }

    public static Student createStudent(String groupNumber, double averageScore, String recordBookNumber) {
        return new Student.StudentBuilder()
                .setGroupNumber(groupNumber)
                .setAverageScore(averageScore)
                .setRecordBookNumber(recordBookNumber)
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
