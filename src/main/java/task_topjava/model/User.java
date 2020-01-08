package task_topjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.OnDelete;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.CollectionUtils;
import task_topjava.model.util.DateTimeUtil;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @Column(name = "email", nullable = false, unique = true)
    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 5, max = 100)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

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

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", vote_time=" + vote_time +
                ", role=" + roles +
                '}';
    }
}
