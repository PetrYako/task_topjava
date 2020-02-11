package com.taskTopjava.util;

import com.taskTopjava.model.restaurant.Dish;
import com.taskTopjava.model.restaurant.Menu;
import com.taskTopjava.model.restaurant.Restaurant;
import com.taskTopjava.to.restaurantTo.RestaurantTo;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtils {

    private RestaurantUtils() {}

    public static RestaurantTo createRestaurantTo(Restaurant restaurant, LocalDate date) {
        Menu menu = restaurant.getMenu().stream().filter(m -> m.getCreateTime().equals(date))
                        .findFirst().orElse(null);
        return new RestaurantTo(restaurant.id(), restaurant.getName(),menu);
    }

    public static List<RestaurantTo> getRestaurants(List<Restaurant> restaurants, LocalDate date) {
        return restaurants.stream().map(r -> createRestaurantTo(r, date)).collect(Collectors.toList());
    }

}
