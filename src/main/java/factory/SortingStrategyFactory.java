package factory;

import model.Bus;
import model.Student;
import model.User;
import strategy.QuickSortStrategy;
import strategy.SortingStrategy;

import java.util.Objects;

public class SortingStrategyFactory {

    public static <T extends Comparable<T>> SortingStrategy<T> createQuickSortStrategy() {
        return new QuickSortStrategy<>();
    }

    public static SortingStrategy<Bus> createEvenOddQuickSortStrategyForBus() {
        return new EvenOddQuickSortStrategy<>(Bus::getMileage);
    }

    public static SortingStrategy<Student> createEvenOddQuickSortStrategyForStudent() {
        return new EvenOddQuickSortStrategy<>(student -> Objects.hash(student.hashCode()));
    }

    public static SortingStrategy<User> createEvenOddQuickSortStrategyForUser() {
        return new EvenOddQuickSortStrategy<>(user -> Objects.hash(user.hashCode()));
    }


    public static <T extends Comparable<T>> SortingStrategy<T> createSortingStrategy(String strategyName, Class<T> clazz) {
        switch (strategyName.toLowerCase()) {
            case "quicksort":
                return createQuickSortStrategy();
            case "evenoddquicksort":
                if (Bus.class.equals(clazz)) {
                    return (SortingStrategy<T>) createEvenOddQuickSortStrategyForBus();
                } else if (Student.class.equals(clazz)) {
                    return (SortingStrategy<T>) createEvenOddQuickSortStrategyForStudent();
                } else if (User.class.equals(clazz)) {
                    return (SortingStrategy<T>) createEvenOddQuickSortStrategyForUser();
                }
            default:
                throw new IllegalArgumentException("Unknown sorting strategy: " + strategyName);
        }
    }

}
