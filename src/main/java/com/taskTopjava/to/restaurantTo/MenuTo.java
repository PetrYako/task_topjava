package com.taskTopjava.to.restaurantTo;

import com.taskTopjava.to.BaseTo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

public class MenuTo extends BaseTo implements Serializable {
    private static final long serialVersionUID = 2L;

    @NotNull
    @Min(0)
    private Integer votes;

    @NotNull
    private LocalDate createTime;

    public MenuTo() {}

    public MenuTo(Integer id, Integer votes, LocalDate createTime) {
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

    @Override
    public String toString() {
        return "MenuTo{" +
                "votes=" + votes +
                ", createTime=" + createTime +
                '}';
    }
}
