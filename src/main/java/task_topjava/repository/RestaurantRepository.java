package task_topjava.repository;

import task_topjava.model.Dish;
import task_topjava.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    Restaurant get(int id);

    boolean delete(int id);

    List<Restaurant> getAll();
}
