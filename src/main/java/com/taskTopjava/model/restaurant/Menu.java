package com.taskTopjava.model.restaurant;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "restaurant_menu")
public class Menu extends AbstractBaseEntity {

    @Column(name = "votes", nullable = false)
    @NotNull
    private Integer votes;

    @Column(name = "create_time", nullable = false)
    @NotNull
    private LocalDate createTime;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id")
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<Dish> dishes;

    public Menu() {}

    public Menu(Integer id, Integer votes, LocalDate createTime) {
        super(id);
        this.votes = votes;
        this.createTime = createTime;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "votes=" + votes +
                ", createTime=" + createTime +
                '}';
    }
}
