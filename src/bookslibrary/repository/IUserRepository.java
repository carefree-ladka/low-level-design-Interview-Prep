package bookslibrary.repository;

import module java.base;
import bookslibrary.model.user.BaseUser;

public interface IUserRepository {
    void save(BaseUser user);

    Optional<BaseUser> findById(String id);

    List<BaseUser> findAll();
}
