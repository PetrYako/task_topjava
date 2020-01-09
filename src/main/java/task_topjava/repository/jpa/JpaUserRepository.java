package task_topjava.repository.jpa;

import org.hibernate.jpa.QueryHints;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import task_topjava.model.User;
import task_topjava.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.QueryHint;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaUserRepository implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public User get(int id) {
        return em.find(User.class, id);
    }

    @Override
    public User save(User user) {
        if (user.isNew()) {
            em.persist(user);
            return user;
        } else {
            return em.merge(user);
        }
    }

    @Override
    public User getByEmail(String email) {
        List<User> userList = em.createNamedQuery(User.BY_EMAIL, User.class)
                                .setParameter("email", email)
                                .setHint(QueryHints.HINT_PASS_DISTINCT_THROUGH, false)
                                .getResultList();
        return DataAccessUtils.singleResult(userList);
    }
}
