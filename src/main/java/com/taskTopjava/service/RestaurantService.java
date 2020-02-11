package com.taskTopjava.service;

import com.taskTopjava.model.restaurant.Menu;
import com.taskTopjava.model.restaurant.Restaurant;
import com.taskTopjava.repository.restaurant.DataRestaurantRepository;
import com.taskTopjava.to.restaurantTo.RestaurantTo;
import com.taskTopjava.util.RestaurantUtils;
import com.taskTopjava.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.taskTopjava.util.RestaurantUtils.createRestaurantTo;
import static com.taskTopjava.util.RestaurantUtils.getRestaurants;
import static com.taskTopjava.util.ValidationUtils.checkNotFoundWithId;

@Service
public class RestaurantService {

    private final DataRestaurantRepository repository;

    @Autowired
    public RestaurantService(DataRestaurantRepository repository) {
        this.repository = repository;
    }

    public List<RestaurantTo> getAll(LocalDate date) {
        return getRestaurants(repository.getAll(), date);
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }
}
