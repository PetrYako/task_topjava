package task_topjava.util;

import task_topjava.model.Dish;
import task_topjava.to.DishTo;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DishUtil {

    private DishUtil() {}

    public static List<DishTo> getTos(Collection<Dish> dishes) {
        return dishes.stream()
                .map(DishUtil::createTo)
                .collect(Collectors.toList());
    }

    public static DishTo createTo(Dish dish) {
        return new DishTo(dish.getId(), dish.getDescription(), dish.getCalories());
    }
}
