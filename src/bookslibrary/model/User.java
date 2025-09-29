package bookslibrary.model;

import bookslibrary.enums.UserType;

public class User {
    private final String id;
    private String name;
    private String email;
    private UserType userType;
    private int maxAllowedBooks; // could be derived from userType

    public User(String id, String name, String email, UserType userType, int maxAllowedBooks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
        this.maxAllowedBooks = maxAllowedBooks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserType getUserType() {
        return userType;
    }

    public int getMaxAllowedBooks() {
        return maxAllowedBooks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setMaxAllowedBooks(int maxAllowedBooks) {
        this.maxAllowedBooks = maxAllowedBooks;
    }

    @Override
    public String toString() {
        return "User{" + id + ", name='" + name + '\'' + ", type=" + userType + '}';
    }
}
