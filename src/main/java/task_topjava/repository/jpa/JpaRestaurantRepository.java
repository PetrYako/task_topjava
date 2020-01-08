package task_topjava.repository.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import task_topjava.model.Dish;
import task_topjava.model.Restaurant;
import task_topjava.repository.RestaurantRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class JpaRestaurantRepository implements RestaurantRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (restaurant.isNew()) {
            em.persist(restaurant);
            return restaurant;
        } else {
            return em.merge(restaurant);
        }
    }

    @Override
    public Restaurant get(int id) {
        return em.find(Restaurant.class, id);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Restaurant.DELETE)
                 .setParameter("id", id)
                 .executeUpdate() != 0;
    }

    @Override
    public Integer getAmountOfVotes(int id) {
        return get(id).getVote_amount();
    }

    @Override
    public void vote(int id) {
        Restaurant restaurant = get(id);
        restaurant.setVote_amount(restaurant.getVote_amount() + 1);
        save(restaurant);
    }

    @Override
    public void unVote(int id) {
        Restaurant restaurant = get(id);
        restaurant.setVote_amount(restaurant.getVote_amount() - 1);
        save(restaurant);
    }
}
