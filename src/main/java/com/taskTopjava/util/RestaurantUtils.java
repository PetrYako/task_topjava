package com.taskTopjava.util;

import com.taskTopjava.model.restaurant.Dish;
import com.taskTopjava.model.restaurant.Menu;
import com.taskTopjava.model.restaurant.Restaurant;
import com.taskTopjava.to.restaurantTo.DishTo;
import com.taskTopjava.to.restaurantTo.MenuTo;
import com.taskTopjava.to.restaurantTo.RestaurantTo;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtils {

    private RestaurantUtils() {}

    public static RestaurantTo createRestaurantTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.id(), restaurant.getName());
    }

    public static List<RestaurantTo> getRestaurantTos(List<Restaurant> restaurants) {
        return restaurants.stream().map(RestaurantUtils::createRestaurantTo).collect(Collectors.toList());
    }

    public static MenuTo createMenuTo(Menu menu) {
        return new MenuTo(menu.id(), menu.getVotes(), menu.getCreateTime());
    }

    public static List<MenuTo> getMenuTos(List<Menu> menus) {
        return menus.stream().map(RestaurantUtils::createMenuTo).collect(Collectors.toList());
    }

    public static DishTo createDishTo(Dish dish) {
        return new DishTo(dish.id(), dish.getDescription(), dish.getPrice());
    }

    public static List<DishTo> getDishTos(List<Dish> dishes) {
        return dishes.stream().map(RestaurantUtils::createDishTo).collect(Collectors.toList());
    }
}
