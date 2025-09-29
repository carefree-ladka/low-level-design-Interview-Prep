package bookslibrary.model.user;

import bookslibrary.enums.UserType;

public abstract class BaseUser {
    protected final String id;
    protected String name;
    protected String email;
    protected final UserType userType;

    public BaseUser(String id, String name, String email, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.userType = userType;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract int getMaxAllowedBooks();
}
