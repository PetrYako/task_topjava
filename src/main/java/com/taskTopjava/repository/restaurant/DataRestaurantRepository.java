package com.taskTopjava.repository.restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataRestaurantRepository implements RestaurantRepository {

    @Autowired
    private CrudRestaurantRepository repository;
}
