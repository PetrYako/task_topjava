package task_topjava.repository;

import task_topjava.model.User;

public interface UserRepository {

    User get(int id);

    User save(User user);

    User getByEmail(String email);

    void clear();
}
