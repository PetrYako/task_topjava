package task_topjava.to;

import org.hibernate.validator.constraints.SafeHtml;
import task_topjava.View;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class RestaurantTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 2L;

    @NotBlank
    @Size(min = 3, max = 50)
    @SafeHtml(groups = {View.Persist.class})
    private String name;

    @NotNull
    private Integer voteAmount;

    public RestaurantTo() {}

    public RestaurantTo(Integer id, String name, Integer voteAmount) {
        super(id);
        this.name = name;
        this.voteAmount = voteAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVoteAmount() {
        return voteAmount;
    }

    public void setVoteAmount(Integer voteAmount) {
        this.voteAmount = voteAmount;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "name=" + name +
                ", voteAmount=" + voteAmount +
                '}';
    }
}
