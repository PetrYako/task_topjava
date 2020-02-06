package com.taskTopjava.model.restaurant;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "restaurant_menu")
public class Menu extends AbstractBaseEntity {

    @Column(name = "votes", nullable = false)
    private Integer votes;

    @Column(name = "create_time", nullable = false)
    private LocalDate createTime;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
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

    @Override
    public String toString() {
        return "Menu{" +
                "votes=" + votes +
                ", createTime=" + createTime +
                '}';
    }
}
