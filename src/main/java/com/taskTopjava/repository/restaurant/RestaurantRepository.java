package com.taskTopjava.repository.restaurant;

import com.taskTopjava.model.restaurant.Restaurant;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface RestaurantRepository {

    Restaurant get(int id);

    Restaurant save(Restaurant restaurant);
}
