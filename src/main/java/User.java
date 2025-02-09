public class User implements Comparable<User>{
    private final String name; //имя
    private final String password; //пароль
    private final String email; //почта

    User(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public int compareTo(User other){
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = this.password.compareTo(other.password);
            if (result == 0) {
                return this.email.compareTo(other.email);
            }
        }
        return result;
    }

    public static class UserBuilder{
        private String name; //имя
        private String password; //пароль
        private String email; //почта

        public UserBuilder name(String name){
            this.name = name;
            return this;
        }

        public UserBuilder password(String password){
            this.password = password;
            return this;
        }

        public UserBuilder email(String email){
            this.email = email;
            return this;
        }

        public User build() {
            return new User(name, password, email);
        }
    }
}