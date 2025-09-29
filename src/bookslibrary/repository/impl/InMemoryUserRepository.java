package bookslibrary.repository.impl;

import module java.base;
import bookslibrary.model.user.BaseUser;
import bookslibrary.repository.IUserRepository;

public class InMemoryUserRepository implements IUserRepository {
    private final Map<String, BaseUser> users = new HashMap<>();

    @Override
    public void save(BaseUser user) {
        users.put(user.getId(), user);
    }

    @Override
    public Optional<BaseUser> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public List<BaseUser> findAll() {
        return new ArrayList<>(users.values());
    }
}
