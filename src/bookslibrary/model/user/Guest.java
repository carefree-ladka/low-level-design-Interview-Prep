package bookslibrary.model.user;

import bookslibrary.enums.UserType;

public class Guest extends BaseUser {
    public Guest(String id, String name, String email) {
        super(id, name, email, UserType.GUEST);
    }

    @Override
    public int getMaxAllowedBooks() {
        return 1;
    }
}
