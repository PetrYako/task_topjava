package com.taskTopjava.web;

import com.taskTopjava.model.restaurant.Menu;
import com.taskTopjava.model.restaurant.Restaurant;
import com.taskTopjava.service.RestaurantService;
import com.taskTopjava.to.restaurantTo.MenuTo;
import com.taskTopjava.to.restaurantTo.RestaurantTo;
import com.taskTopjava.util.RestaurantUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public RestaurantTo get() {
        return service.get(100000, LocalDate.of(2020, 1, 27));
    }
}
