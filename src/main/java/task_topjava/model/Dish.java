package task_topjava.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import task_topjava.View;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({
        @NamedQuery(name = Dish.DELETE, query = "DELETE FROM Dish d WHERE d.id=:id AND d.restaurant.id=:restaurantId"),
        @NamedQuery(name = Dish.GET_ALL, query = "SELECT Dish FROM Dish d WHERE d.restaurant.id=:restaurantId"),
        @NamedQuery(name = Dish.CLEAR, query = "DELETE FROM Dish")
})
@Entity
@Table(name = "restaurant_dishes")
public class Dish extends AbstractBaseEntity {
    public static final String DELETE = "Dish.delete";
    public static final String GET_ALL = "Dish.getAll";
    public static final String CLEAR = "Dish.clear";

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "calories", nullable = false)
    private Integer calories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(groups = View.Persist.class)
    private Restaurant restaurant;

    public Dish() {}

    public Dish(Integer id, String description, Integer calories) {
        super(id);
        this.description = description;
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "description=" + description +
                ", calories=" + calories +
                + '}';
    }
}
