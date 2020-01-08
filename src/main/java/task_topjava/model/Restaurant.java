package task_topjava.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Column(name = "vote_amount", nullable = false)
    @NotNull
    private Integer vote_amount;

    @OneToMany(fetch = FetchType.LAZY)
    protected List<Dish> dishes;

    public Restaurant() {}

    public Restaurant(Integer id, String name, Integer vote_amount) {
        super(id, name);
        this.vote_amount = vote_amount;
    }

    public Integer getVote_amount() {
        return vote_amount;
    }

    public void setVote_amount(Integer vote_amount) {
        this.vote_amount = vote_amount;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name=" + name +
                ", vote_amount=" + vote_amount +
                '}';
    }
}