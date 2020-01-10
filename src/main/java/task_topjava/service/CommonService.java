package task_topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("commonService")
public class CommonService {

    private final UserService userService;
    private final RestaurantService restaurantService;
    private final DishService dishService;

    @Autowired
    public CommonService(UserService userService, RestaurantService restaurantService, DishService dishService) {
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.dishService = dishService;
    }

    public void vote(int userId, int restaurantId, LocalDateTime ldt) {
        userService.vote(userId, ldt);
        restaurantService.vote(restaurantId);
    }

    public void unVote(int userId, int restaurantId) {
        userService.unVote(userId);
        restaurantService.unVote(restaurantId);
    }

    public void newDay() {
        restaurantService.clear();
        dishService.clear();
        userService.clear();
    }
}
