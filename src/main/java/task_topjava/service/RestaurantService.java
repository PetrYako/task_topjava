package task_topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import task_topjava.model.Restaurant;
import task_topjava.repository.RestaurantRepository;
import task_topjava.util.ValidationUtil;

import java.util.List;

import static task_topjava.util.ValidationUtil.checkNotFoundWithId;

@Service("restaurantService")
public class RestaurantService {

    private final RestaurantRepository repository;

    @Autowired
    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public Restaurant create(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        return repository.save(restaurant);
    }

    public void update(Restaurant restaurant) {
        Assert.notNull(restaurant, "restaurant must not be null");
        repository.save(restaurant);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public Restaurant get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Restaurant> getAll() {
        return repository.getAll();
    }

    public void vote(int id) {
        Restaurant entity = get(id);
        entity.setVoteAmount(entity.getVoteAmount() + 1);
        update(entity);
    }

    public void unVote(int id) {
        Restaurant entity = get(id);
        entity.setVoteAmount(entity.getVoteAmount() - 1);
        update(entity);
    }

    public void clear() {
        repository.clear();
    }
}
