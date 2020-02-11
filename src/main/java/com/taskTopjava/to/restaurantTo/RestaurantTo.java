package com.taskTopjava.to.restaurantTo;

import com.taskTopjava.model.restaurant.Menu;
import com.taskTopjava.to.BaseTo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RestaurantTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 3L;

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotNull
    private Menu menu;

    public RestaurantTo() {}

    public RestaurantTo(Integer id, String name, Menu menu) {
        super(id);
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "name='" + name + '\'' +
                '}';
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
