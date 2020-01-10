package task_topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import task_topjava.model.User;
import task_topjava.repository.UserRepository;
import task_topjava.util.UserUtil;
import task_topjava.util.ValidationUtil;

import java.time.LocalDateTime;

import static task_topjava.util.UserUtil.prepareToSave;
import static task_topjava.util.ValidationUtil.*;

@Service("userService")
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(User user) {
        Assert.notNull(user, "user must not be null");
        return prepareAndSave(user);
    }

    public void update(User user) {
        Assert.notNull(user,  "user must not be null");
        prepareAndSave(user);
    }

    public User get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public User getByEmail(String email) {
        Assert.notNull(email, "email must not be null");
        return checkNotFound(repository.getByEmail(email), "email=" + email);
    }

    public void vote(int id, LocalDateTime ldt) {
        User entity = get(id);
        entity.setVoteTime(ldt);
        update(entity);
    }

    public void unVote(int id) {
        User entity = get(id);
        checkDate(entity.getVoteTime());
        entity.setVoteTime(null);
        update(entity);
    }

    public void clear() {
        repository.clear();
    }
    private User prepareAndSave(User user) { return repository.save(prepareToSave(user, passwordEncoder)); }

}
