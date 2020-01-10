package task_topjava.repository;

import task_topjava.model.Dish;

import java.util.List;

public interface DishRepository {

    Dish save(Dish dish, int id);

    Dish get(int id, int restaurantId);

    boolean delete(int id, int restaurantId);

    List<Dish> getAll(int restaurantId);

    void clear();
}
