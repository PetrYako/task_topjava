package task_topjava.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "restaurant_dishes")
public class Dish extends AbstractBaseEntity{

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 3, max = 50)
    private String description;

    @Column(name = "calories", nullable = false)
    @NotNull
    @Range(min = 10, max = 5000)
    private Integer calories;

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

    @Override
    public String toString() {
        return "Dish{" +
                "description=" + description +
                ", calories=" + calories +
                + '}';
    }
}
