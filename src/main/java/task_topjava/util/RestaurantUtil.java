package task_topjava.util;

import task_topjava.model.Restaurant;
import task_topjava.to.RestaurantTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RestaurantUtil {

    private RestaurantUtil() {}

    public static List<RestaurantTo> getTos(Collection<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantUtil::createTo)
                .collect(Collectors.toList());
    }

    public static RestaurantTo createTo(Restaurant restaurant) {
        return new RestaurantTo(restaurant.getId(), restaurant.getName(), restaurant.getVoteAmount());
    }
}
