package com.taskTopjava.repository.restaurant;

import com.taskTopjava.model.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public class DataRestaurantRepository implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository repository;

    @Override
    public Restaurant get(int id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Restaurant save(Restaurant restaurant) {
        if (!restaurant.isNew()) {
            return null;
        }
        return repository.save(restaurant);
    }
}
