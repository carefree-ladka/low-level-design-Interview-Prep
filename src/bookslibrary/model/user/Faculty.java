package bookslibrary.model.user;

import bookslibrary.enums.UserType;

public class Faculty extends BaseUser {
    public Faculty(String id, String name, String email) {
        super(id, name, email, UserType.FACULTY);
    }

    @Override
    public int getMaxAllowedBooks() {
        return 5;
    }
}
