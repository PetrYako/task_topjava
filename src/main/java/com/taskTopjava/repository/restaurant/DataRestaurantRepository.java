package com.taskTopjava.repository.restaurant;

import com.taskTopjava.model.restaurant.Menu;
import com.taskTopjava.model.restaurant.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class DataRestaurantRepository implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository repository;

    @Override
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Restaurant create(Restaurant restaurant) {
        if (!restaurant.isNew()) {
            return null;
        }
        return repository.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id) != 0;
    }
}
