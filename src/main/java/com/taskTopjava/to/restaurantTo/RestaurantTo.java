package com.taskTopjava.to.restaurantTo;

import com.taskTopjava.to.BaseTo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RestaurantTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 3L;

    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    public RestaurantTo() {}

    public RestaurantTo(Integer id, String name) {
        super(id);
        this.name = name;
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
}
