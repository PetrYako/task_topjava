package task_topjava.to;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import task_topjava.View;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.beans.ConstructorProperties;
import java.io.Serializable;
import java.util.Objects;

public class DishTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 3, max = 50)
    @SafeHtml(groups = {View.Web.class})
    private String description;

    @NotNull
    @Range(min = 10, max = 5000)
    private Integer calories;

    public DishTo() {}

    public DishTo(Integer id, String description, Integer calories) {
        super(id);
        this.description = description;
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "DishTo{" +
                "id=" + id +
                ", description=" + description +
                ", calories=" + calories +
                '}';
    }
}
