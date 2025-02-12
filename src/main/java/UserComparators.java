public class UserComparators {

    public static class SortByName implements ComparatorStrategy<User> {
        @Override
        public int compare(User u1, User u2) {
            return u1.getName().compareTo(u2.getName());
        }
    }

    public static class SortByEmail implements ComparatorStrategy<User> {
        @Override
        public int compare(User u1, User u2) {
            return u1.getEmail().compareTo(u2.getEmail());
        }
    }

    public static class SortByPassword implements ComparatorStrategy<User> {
        @Override
        public int compare(User u1, User u2) {
            return u1.getPassword().compareTo(u2.getPassword());
        }
    }
}

