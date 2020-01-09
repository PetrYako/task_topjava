package task_topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.Assert;
import task_topjava.model.Dish;
import task_topjava.repository.DishRepository;
import task_topjava.util.DateTimeUtil;
import task_topjava.util.ValidationUtil;

import java.util.List;

import static task_topjava.util.ValidationUtil.*;

@Service("dishService")
public class DishService {

    private final DishRepository repository;

    @Autowired
    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish get(int id, int restaurantId) { return checkNotFoundWithId(repository.get(id, restaurantId), id); }

    public void delete(int id, int restaurantId) { checkNotFoundWithId(repository.delete(id, restaurantId), id); }

    public List<Dish> getAll(int restaurantId) { return repository.getAll(restaurantId); }

    public void update(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        checkNotFoundWithId(repository.save(dish, restaurantId), dish.getId());
    }

    public Dish create(Dish dish, int restaurantId) {
        Assert.notNull(dish, "dish must not be null");
        return repository.save(dish, restaurantId);
    }
}
