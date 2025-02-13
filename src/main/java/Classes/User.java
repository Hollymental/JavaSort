package Classes;

public class User implements Comparable<User>{
    private final String name; //имя
    private final String password; //пароль
    private final String email; //почта

    User(String name, String password, String email){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getName() {return name;} // получить имя

    public String getPassword() {return password;} //получить пароль

    public String getEmail() {return email;} //получить почту

    @Override
    public String toString() {
        return String.format("User [ name: %-10s password: %-14s email: %-10s ]", name, password, email);
    }

    public int compareTo(User other){ //сравнение
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

        public UserBuilder setName(String name){
            this.name = name;
            return this;
        }

        public UserBuilder setPassword(String password){
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email){
            this.email = email;
            return this;
        }

        public User build() {
            return new User(name, password, email);
        }
    }
}