package task_topjava.repository;

import task_topjava.model.Dish;
import task_topjava.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {
    Restaurant save(Restaurant restaurant);

    Restaurant get(int id);

    boolean delete(int id);

    Integer getAmountOfVotes(int id);

    void vote(int id);

    void unVote(int id);
}
