package task_topjava.web.dish;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import task_topjava.model.Dish;
import task_topjava.to.DishTo;

import java.util.List;

@RestController
@RequestMapping("/restaurant/dishes")
public class DishController extends AbstractDishController {

    @Override
    public DishTo get(int id, int restaurantId) {
        return super.get(id, restaurantId);
    }

    @Override
    public void delete(int id, int restaurantId) {
        super.delete(id, restaurantId);
    }

    @Override
    public List<DishTo> getAll(int restaurantId) {
        return super.getAll(restaurantId);
    }

    @Override
    public void update(Dish dish, int id, int restaurantId) {
        super.update(dish, id, restaurantId);
    }

    @Override
    public DishTo create(Dish dish, int restaurantId) {
        return super.create(dish, restaurantId);
    }
}
