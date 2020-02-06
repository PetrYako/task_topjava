package com.taskTopjava.service;

import com.taskTopjava.model.restaurant.Restaurant;
import com.taskTopjava.repository.restaurant.DataRestaurantRepository;
import com.taskTopjava.to.restaurantTo.RestaurantTo;
import com.taskTopjava.util.RestaurantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import static com.taskTopjava.util.RestaurantUtils.createRestaurantTo;

@Service
public class RestaurantService {

    private final DataRestaurantRepository repository;

    @Autowired
    public RestaurantService(DataRestaurantRepository repository) {
        this.repository = repository;
    }

    public RestaurantTo get(int id, LocalDate date) {
        return createRestaurantTo(repository.get(id), date);
    }
}
