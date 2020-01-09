package task_topjava.model;

import org.hibernate.validator.constraints.SafeHtml;
import task_topjava.View;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@NamedQueries({
        @NamedQuery(name = Restaurant.DELETE, query = "DELETE FROM Restaurant r WHERE r.id=:id"),
        @NamedQuery(name = Restaurant.GET_ALL, query = "SELECT r FROM Restaurant r")
})
@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {
    public static final String DELETE = "Restaurant.delete";
    public static final String GET_ALL = "Restaurant.getAll";

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "vote_amount", nullable = false)
    private Integer voteAmount;

    @OneToMany(fetch = FetchType.LAZY)
    protected List<Dish> dishes;

    public Restaurant() {}

    public Restaurant(Integer id, String name, Integer voteAmount) {
        super(id, name);
        this.voteAmount = voteAmount;
    }

    public Integer getVoteAmount() {
        return voteAmount;
    }

    public void setVoteAmount(Integer voteAmount) {
        this.voteAmount = voteAmount;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name=" + name +
                ", voteAmount=" + voteAmount +
                '}';
    }
}
