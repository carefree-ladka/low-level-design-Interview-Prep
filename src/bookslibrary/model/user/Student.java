package bookslibrary.model.user;

import bookslibrary.enums.UserType;

public class Student extends BaseUser {
    public Student(String id, String name, String email) {
        super(id, name, email, UserType.STUDENT);
    }

    @Override
    public int getMaxAllowedBooks() {
        return 3;
    }
}
