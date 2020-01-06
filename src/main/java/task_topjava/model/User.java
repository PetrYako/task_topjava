package task_topjava.model;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import task_topjava.model.util.DateTimeUtil;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User extends AbstractBaseEntity{

    @Column(name = "vote_time", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    private LocalDateTime vote_time;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vote_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.LAZY)
    @BatchSize(size = 100)
    private Set<Role> roles;

    public User() {}

    public User(Integer id, LocalDateTime vote_time, Role role,  Role... roles) {
        this(id, vote_time, EnumSet.of(role, roles));
    }

    public User(Integer id, LocalDateTime vote_time, Collection<Role> roles) {
        super(id);
        this.vote_time = vote_time;
        setRoles(roles);
    }

    public LocalDateTime getVote_time() {
        return vote_time;
    }

    public void setVote_time(LocalDateTime vote_time) {
        this.vote_time = vote_time;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", vote_time=" + vote_time +
                ", restaurant_id=" + restaurant.id +
                ", role=" + roles +
                '}';
    }
}
