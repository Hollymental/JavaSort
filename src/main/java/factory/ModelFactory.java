package factory;

import model.Bus;
import model.Student;
import model.User;

import java.util.Random;

public class ModelFactory {
    private static final Random random = new Random();
    static String[] names = new String[] {
        "Александр","Екатерина","Дмитрий","Анна", "Сергей","Мария",
                "Анастасия","Иван","Ольга","Владимир","Татьяна",
                "Максим", "Елена", "Николай", "Юлия"
    };

    public static Bus createRandomBus() {
        return new Bus.BusBuilder()
                .setNumber("A" + random.nextInt(1000, 9999))
                .setModel("Model-" + random.nextInt(5))
                .setMileage(random.nextInt(100000))
                .build();
    }

    public static Student createRandomStudent() {
        return new Student.StudentBuilder()
                .setGroupNumber("Group-" + random.nextInt(5))
                .setAverageScore(3 + random.nextDouble() * 2)
                .setRecordBookNumber("B"+ random.nextInt(1000, 9999))
                .build();
    }

    public static User createRandomUser() {
        return new User.UserBuilder()
                .setName(names[random.nextInt(14)])
                .setPassword("pass" + random.nextInt(1000, 9999))
                .setEmail("email" + random.nextInt(10, 99) + "@gmail.com")
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
