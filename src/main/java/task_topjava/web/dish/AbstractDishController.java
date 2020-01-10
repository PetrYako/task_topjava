package task_topjava.web.dish;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import task_topjava.model.Dish;
import task_topjava.service.DishService;
import task_topjava.to.DishTo;
import task_topjava.util.DishUtil;
import task_topjava.util.ValidationUtil;

import java.util.List;

import static task_topjava.util.ValidationUtil.assureIdConsistent;
import static task_topjava.util.ValidationUtil.checkNew;

public class AbstractDishController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private DishService service;

    public DishTo get(int id, int restaurantId) {
        log.info("get dish {} for restaurant {}", id, restaurantId);
        return DishUtil.createTo(service.get(id, restaurantId));
    }

    public void delete(int id, int restaurantId) {
        log.info("delete dish {} for restaurant {}", id, restaurantId);
        service.delete(id, restaurantId);
    }

    public List<DishTo> getAll(int restaurantId) {
        log.info("getAll for restaurant {}", restaurantId);
        return DishUtil.getTos(service.getAll(restaurantId));
    }

    public void update(Dish dish, int id, int restaurantId) {
        assureIdConsistent(dish, restaurantId);
        log.info("update dish {} for restaurant {}", id, restaurantId);
        service.update(dish, id, restaurantId);
    }

    public DishTo create(Dish dish, int restaurantId) {
        checkNew(dish);
        log.info("create dish {} for restaurant {}", dish, restaurantId);
        return DishUtil.createTo(service.create(dish, restaurantId));
    }
}
