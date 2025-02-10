package model;

import java.util.Objects;

public class User implements Comparable<User> {
    private final String name;
    private final String password;
    private final String email;

    private User(UserBuilder builder) {
        this.name = builder.name;
        this.password = builder.password;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int compareTo(User other) {
        int result = this.name.compareTo(other.name);
        if (result == 0) {
            result = this.password.compareTo(other.password);
            if (result == 0) {
                return this.email.compareTo(other.email);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("User [ name: %-10s password: %-10s email: %-10s ]", name, password, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email);
    }

    public static class UserBuilder {
        private String name;
        private String password;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
