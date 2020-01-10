package task_topjava.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import task_topjava.View;
import task_topjava.util.DateTimeUtil;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = User.BY_EMAIL, query = "SELECT u FROM User u WHERE u.email=:email"),
        @NamedQuery(name = User.CLEAR, query = "UPDATE User SET voteTime=null")
})
@Entity
@Table(name="users")
public class User extends AbstractBaseEntity implements HasEmail {
    public static final String BY_EMAIL = "User.byEmail";
    public static final String CLEAR = "User.clear";

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(name = "vote_time")
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    @Nullable
    private LocalDateTime voteTime;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.LAZY)
    @BatchSize(size = 100)
    private Set<Role> roles;

    public User() {}

    public User(Integer id, LocalDateTime voteTime, Role role,  Role... roles) {
        this(id, voteTime, EnumSet.of(role, roles));
    }

    public User(Integer id, LocalDateTime voteTime, Collection<Role> roles) {
        super(id);
        this.voteTime = voteTime;
        setRoles(roles);
    }

    public LocalDateTime getVoteTime() {
        return voteTime;
    }

    public void setVoteTime(LocalDateTime voteTime) {
        this.voteTime = voteTime;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @Override
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
                ", voteTime=" + voteTime +
                ", role=" + roles +
                '}';
    }
}
