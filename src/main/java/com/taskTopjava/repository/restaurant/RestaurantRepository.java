package com.taskTopjava.repository.restaurant;

import com.taskTopjava.model.restaurant.Menu;
import com.taskTopjava.model.restaurant.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RestaurantRepository {

    List<Restaurant> getAll();

    Restaurant create(Restaurant restaurant);

    boolean delete(int id);
}
